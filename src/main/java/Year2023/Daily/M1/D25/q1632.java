package Year2023.Daily.M1.D25;

public class q1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        // 并查集 + 拓扑排序
        int m = matrix.length, n = matrix[0].length;
        UnionFind uf = new UnionFind(m, n);
        return new int[0][0];
    }
}


class UnionFind{
    int m, n;
    int[][][] root;
    int[][] size;

    public UnionFind(int m, int n){
        this.m = m;
        this.n = n;
        this.root = new int[m][n][2];
        this.size = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                root[i][j][0] = i;
                root[i][j][1] = j;
                size[i][j] = 1;
            }
        }
    }


    public int[] find(int i, int j){
        int[] rootArr = root[i][j];
        int ri = rootArr[0], rj = rootArr[1];
        if(ri == i && rj == j){
            return rootArr;
        }

        return find(ri, rj);
    }

    public void union(int i1, int j1, int i2, int j2) {
        int[] rootArr1 = find(i1, j1);
        int[] rootArr2 = find(i2, j2);
        int ri1 = rootArr1[0], rj1 = rootArr1[1];
        int ri2 = rootArr2[0], rj2 = rootArr2[1];
        if (ri1 != ri2 || rj1 != rj2) {
            if (size[ri1][rj1] >= size[ri2][rj2]) {
                root[ri2][rj2][0] = ri1;
                root[ri2][rj2][1] = rj1;
                size[ri1][rj1] += size[ri2][rj2];
            } else {
                root[ri1][rj1][0] = ri2;
                root[ri1][rj1][1] = rj2;
                size[ri2][rj2] += size[ri1][rj1];
            }
        }
    }


}
