package Year2023.Daily.M2.D12;

public class q1138 {
    public String alphabetBoardPath(String target) {
        int cx = 0, cy = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);

            int nx = (c - 'a') / 5;
            int ny = (c - 'a') % 5;
            if(nx < cx){
                for (int j = 0; j < cx - nx; j++) {
                    sb.append('U');
                }
            }

            if(ny < cy){
                for (int j = 0; j < cy - ny; j++) {
                    sb.append('L');
                }
            }

            if(nx > cx){
                for (int j = 0; j < nx - cx; j++) {
                    sb.append('D');
                }
            }

            if(ny > cy){
                for (int j = 0; j < ny - cy; j++) {
                    sb.append('R');
                }
            }

            sb.append('!');
            cx = nx;
            cy = ny;
        }

        return sb.toString();
    }
}
