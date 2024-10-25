import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 집의 개수 n개
        int[][] arr = new int[n][3]; // [n개의 집][빨강, 초록, 파랑]
        int[][] dp = new int[n][3];
        StringTokenizer tr;

        for(int i = 0; i < n; i++){ // arr[][] 입력 받기
            tr = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(tr.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){ // n개의 집을 칠해야되니까 n번만큼
            for(int j = 0; j < 3; j++){ // 빨강, 초록, 파랑 중 하나로 색칠
                if(j == 0){ // 빨간색을 칠하는 비용 + 앞 집을 초록 or 파랑으로 칠하는 비용 중 더 적게 드는 비용을 더해서 dp에 저장
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                } else if (j == 1) { // 초록색을 칠하는 비용 + 앞 집을 빨강 or 파랑으로 칠하는 비용 중 더 적게 드는 비용을 더해서 dp에 저장
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                } else if (j == 2) { // 파랑색을 칠하는 비용 + 앞 집을 빨강 or 초록으로 칠하는 비용 중 더 적게 드는 비용을 더해서 dp에 저장
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
            if(i == n - 1){ // 마지막 집을 칠했으면 dp에 저장된 마지막 3개 값 중 작은 값 출력
                min = Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2]));
            }
        }
        System.out.println(min);

    }
}