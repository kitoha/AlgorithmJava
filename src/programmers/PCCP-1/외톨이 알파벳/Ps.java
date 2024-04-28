
public class Ps {
    public String solution(String input_string) {
        int[] alpabet = new int[27];

        int n = input_string.length();
        alpabet[input_string.charAt(0) - 'a'] = 1;

        for (int i = 1; i < n; i++) {
            char before = input_string.charAt(i - 1);
            char after = input_string.charAt(i);
            int number = input_string.charAt(i) - 'a';
            if (before != after) {
                alpabet[number]++;
            }
        }

        String answer = "";
        for (int i = 0; i < 27; i++) {
            if (alpabet[i] >= 2) {
                char alpa = (char) (i + 'a');
                answer += alpa;
            }
        }

        return answer.isEmpty() ? "N" : answer;
    }

}
