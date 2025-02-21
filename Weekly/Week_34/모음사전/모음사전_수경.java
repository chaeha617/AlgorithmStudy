class Solution {
    static String[] str = {"A", "E", "I", "O", "U"};
    static int count = 0;
    static boolean found = false;

    public static void backtrack(String temp, String word) {
        if (found) return;

        if (temp.equals(word)) {
            found = true;
            return;
        }

        if (temp.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            count++;
            backtrack(temp + str[i], word);
            if (found) return;
        }
    }

    public static int solution(String word) {
        count = 0;
        found = false;
        backtrack("", word);
        return count;
    }
}