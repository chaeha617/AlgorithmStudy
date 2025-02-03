import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tr.nextToken());
        int k = Integer.parseInt(tr.nextToken());
        int[][] dp = new int[n + 1][k + 1];
        Arrays.fill(dp[0], 1);


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(j == 1) dp[i][j] = 1;
                else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}