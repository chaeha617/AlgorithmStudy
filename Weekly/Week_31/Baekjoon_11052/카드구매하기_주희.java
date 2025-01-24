import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11052 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] list = new int[N + 1];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i < N + 1; i++) {
            int a = Integer.parseInt(st.nextToken());
            list[i] = a;
        }

        dp[1] = list[1];

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    int a = i / j;
                    dp[i] = Math.max(list[i], list[j] * a);
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N; j++) {
                if (i + j <= N) {
                    dp[i+j] = Math.max(dp[i+j], dp[i]+dp[j]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
