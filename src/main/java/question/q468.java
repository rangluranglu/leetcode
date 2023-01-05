package question;

public class q468 {
    public String validIPAddress(String queryIP) {
        // 区分ipv4 和 ipv6
        String ipv4 = "IPv4";
        String ipv6 = "IPv6";
        String neither = "Neither";
        if(queryIP.indexOf('.') >= 0){
            int last = -1;

            for (int i = 0; i < 4; i++) {
                int cur = (i == 3? queryIP.length() : queryIP.indexOf('.', last + 1));

                if(cur < 0){
                    return neither;
                }

                if(cur - last - 1 < 1 || cur - last - 1 > 3){
                    return neither;
                }

                int addr = 0;
                for(int j = last + 1; j < cur; j++){
                    if(!Character.isDigit(queryIP.charAt(j))){
                        return neither;
                    }

                    addr = addr * 10 + (queryIP.charAt(j) - '0');
                }

                if(addr > 255 || (addr > 0 && queryIP.charAt(last + 1) == '0') ||
                        (addr == 0 && cur - last - 1 > 1)){
                    return neither;
                }

                last = cur;
            }
            return ipv4;
        }else {
            //
            int last = -1;
            for(int i = 0; i < 8; i++){
                int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
                if(cur < 0){
                    return neither;
                }

                if(cur - last - 1 < 1 || cur - last - 1 > 4){
                    return neither;
                }

                for(int j = last + 1; j < cur; j++){
                    if(!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')){
                        return neither;
                    }
                }
                last = cur;
            }

            return ipv6;
        }

    }
}
