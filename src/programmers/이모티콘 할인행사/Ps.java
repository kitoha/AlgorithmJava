class Ps {
    private static int n;
    private static int[] rate = { 10, 20, 30, 40 };
    private static int[] ans;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        ans = new int[2];
        n = emoticons.length;
        int[] percentage = new int[n];

        dfs(0, percentage, users, emoticons);
        answer[0] = ans[0];
        answer[1] = ans[1];
        return answer;
    }

    public static int dfs(int idx, int[] percentage, int[][] users, int[] emoticons) {
        if (idx >= n) {
            int signUpUserCount = 0;
            int money = 0;
            for (int i = 0; i < users.length; i++) {
                int[] userInfo = users[i];
                int sum = 0;
                for (int j = 0; j < percentage.length; j++) {
                    int percent = percentage[j];

                    if (userInfo[0] > percent) {
                        continue;
                    }

                    int price = (emoticons[j] * (100 - percent)) / 100;
                    sum += price;
                }

                if (sum >= userInfo[1]) {
                    signUpUserCount++;
                } else {
                    money += sum;
                }
            }

            if (signUpUserCount > ans[0]) {
                ans[0] = signUpUserCount;
                ans[1] = money;
            } else if (signUpUserCount == ans[0]) {
                ans[1] = Math.max(ans[1], money);
            }

            return 0;
        }

        for (int i = 0; i < rate.length; i++) {
            percentage[idx] = rate[i];
            dfs(idx + 1, percentage, users, emoticons);
        }

        return 0;
    }
}