import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] answerList = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && list[stack.peek()] <= list[i]) {
                stack.pop();
            }


            if (!stack.isEmpty()) {
                answerList[i] = stack.peek() + 1;
            } else {
                answerList[i] = 0;
            }

            stack.push(i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stringBuilder.append(answerList[i]).append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }
}
