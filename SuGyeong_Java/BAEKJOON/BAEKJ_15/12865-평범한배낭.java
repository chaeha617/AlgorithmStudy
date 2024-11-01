import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader와 StringTokenizer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());

        // n: 물품의 수, k: 최대 배낭의 무게
        int n = Integer.parseInt(tr.nextToken());
        int k = Integer.parseInt(tr.nextToken());

        // arr 배열: 각 물품의 [무게, 가치]를 저장
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            tr = new StringTokenizer(br.readLine()); // 한 줄씩 입력 받음
            arr[i][0] = Integer.parseInt(tr.nextToken()); // 물품의 무게
            arr[i][1] = Integer.parseInt(tr.nextToken()); // 물품의 가치
        }

        // dp 배열: dp[i][j]는 i번째 물품까지 고려했을 때 무게 j에서의 최대 가치
        int[][] dp = new int[n + 1][k + 1]; // dp 배열 초기화, 물품 0~n개, 무게 0~k까지

        // 동적 프로그래밍을 이용해 배낭 문제 해결
        for (int i = 1; i < n + 1; i++) {
            int weight = arr[i - 1][0]; // i번째 물품의 무게
            int value = arr[i - 1][1];  // i번째 물품의 가치
            for (int j = 1; j < k + 1; j++) {
                // 현재 배낭 무게 j가 물품의 무게보다 작으면 이전 값을 그대로 유지
                if (j < weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 물품을 담지 않는 경우 vs 물품을 담는 경우 중 더 큰 가치를 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                }
            }
        }

        // 최대 가치를 출력 (n개의 물품을 고려했을 때 배낭의 최대 무게가 k일 때)
        System.out.println(dp[n][k]);
    }
}
