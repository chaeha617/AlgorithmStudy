import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            boolean isGroupWord = true;
            HashSet<Character> seen = new HashSet<>();

            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);

                if (seen.contains(currentChar)) {
                    if (currentChar != word.charAt(j - 1)) {
                        isGroupWord = false;
                        break;
                    }
                }

                seen.add(currentChar);
            }

            if (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
