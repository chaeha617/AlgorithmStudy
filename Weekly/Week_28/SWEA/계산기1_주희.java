import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            String line = sc.next();
            stack.push(line.charAt(0) - '0');
            for (int i = 1; i < line.length(); i++) {
                if (line.charAt(i) != '+') {
                    stack.push(stack.pop() + line.charAt(i) - '0');
                }
            }
            System.out.println("#" + test_case + " " + stack.pop());
        }
    }
}