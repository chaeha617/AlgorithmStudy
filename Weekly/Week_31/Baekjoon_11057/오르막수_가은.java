import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][11];
        Arrays.fill(dp[0], 1);

        for (int i=1; i<=N; i++) {
            dp[i][0] = 1;
            for (int j=1; j<10; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) %10007;
            }

        }

        System.out.println(dp[N][9]);
    }
}