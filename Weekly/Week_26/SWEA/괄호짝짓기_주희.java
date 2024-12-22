import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class 괄호짝짓기_주희 {
    static List<Character> open = Arrays.asList('(', '[', '{', '<');
    static List<Character> close = Arrays.asList(')', ']', '}', '>');

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int length = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();

            List<Character> stack = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                char temp = input.charAt(i);
                if (open.contains(temp)) {
                    stack.add(temp);
                } else if (close.contains(temp)) {
                    if (stack.isEmpty() || !isMatchingPair(stack.get(stack.size() - 1), temp)) {
                        stack.add(temp);
                        break;
                    }
                    stack.remove(stack.size() - 1);
                }
            }

            System.out.println("#" + test_case + " " + (stack.isEmpty() ? 1 : 0));
        }
    }

    private static boolean isMatchingPair(char openChar, char closeChar) {
        return (openChar == '(' && closeChar == ')') ||
                (openChar == '[' && closeChar == ']') ||
                (openChar == '{' && closeChar == '}') ||
                (openChar == '<' && closeChar == '>');
    }
}
