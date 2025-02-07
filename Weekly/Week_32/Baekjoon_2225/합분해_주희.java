import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][N+1];

        for (int i = 1; i < K+1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < K+1; i++) {
            for (int j = 0; j < N+1; j++) {
                if (j == 0) {
                    dp[i][j]= 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}