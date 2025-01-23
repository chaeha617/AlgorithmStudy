import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] ansArr = new int[n];
        StringTokenizer tr = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tr.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ansArr[i] = 0;
            } else {
                ansArr[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ansArr[i] + " ");
        }
    }
}
