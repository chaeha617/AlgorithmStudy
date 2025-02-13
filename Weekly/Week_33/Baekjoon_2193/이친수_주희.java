import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이친수_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;

        if (N > 2) {
            for (int i = 3; i < N+1; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        System.out.println(dp[N]);
    }
}
