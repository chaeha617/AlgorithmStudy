import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tr.nextToken());
            int m = Integer.parseInt(tr.nextToken());
            int[][] dp = new int[n + 1][m + 1];

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(i == 1) dp[i][j] = j;
                    else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
