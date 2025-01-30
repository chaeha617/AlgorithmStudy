import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 10; j++){
                if(i == 1){
                    if(j != 0){
                        dp[i][j] = 1;
                    }
                } else {
                    if(j == 0){
                        dp[i][j] = dp[i - 1][j + 1];
                    } else if (j == 9) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                    }
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < 10; i++){
            ans += dp[n][i];
        }
        System.out.println(ans % 1000000000);
    }
}