package WeekCompetition.year2022.W319;

import Common.TreeNode;

import java.util.*;

public class q2471 {
    public int minimumOperations(TreeNode root) {

        // 离散化 + 置换环
        Queue<TreeNode> queue = new ArrayDeque<>();

        int ans = 0;
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int[] arr = new int[size];
            int[] tmp = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arr[i] = tmp[i] = node.val;

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            Map<Integer, Integer> map = new HashMap<>();

            Arrays.sort(tmp);
            // 找到最小交换数
            for (int i = 0; i < size; i++) {
                map.put(tmp[i], i);
            }

            for (int i = 0; i < size; i++) {
                // 找到置换环
                while(arr[i] != tmp[i]){
                    int j = map.get(arr[i]);
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    ans ++;
                }
            }
        }

        return ans;
    }
}
