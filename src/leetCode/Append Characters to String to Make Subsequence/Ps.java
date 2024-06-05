class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(index)) {
                index++;
            }

            if (index == m) {
                break;
            }
        }

        return m - index;
    }
}