class Solution {
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int length = s.length();

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= length / 2; i++) {
            String prefix = "";
            int cnt = 0;
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j + i <= length; j += i) {
                String subString = s.substring(j, j + i);

                if (prefix.isEmpty()) {
                    prefix = subString;
                    cnt++;
                } else if (prefix.equals(subString)) {
                    cnt++;
                } else {
                    stringBuffer.append(cnt > 1 ? cnt + prefix : prefix);
                    prefix = subString;
                    cnt = 1;
                }
            }

            stringBuffer.append(cnt > 1 ? cnt + prefix : prefix);

            int n = s.length();
            if (n % i > 0) {
                String postFix = s.substring(n - (n % i), n);
                stringBuffer.append(postFix);
            }

            answer = Math.min(answer, stringBuffer.toString().length());
        }
        return answer;
    }
}