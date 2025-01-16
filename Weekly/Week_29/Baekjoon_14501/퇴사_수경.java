import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer tr = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                dp[j][i] = Integer.parseInt(tr.nextToken());
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if((i - j) >= dp[0][j]){
                    max = Math.max(max, dp[1][j]);
                }
            }
            if((dp[0][i] + i) <= n + 1){
                dp[1][i] = dp[1][i] + max;
                ans = Math.max(ans, dp[1][i]);
            }

        }
        System.out.println(ans);
    }
}