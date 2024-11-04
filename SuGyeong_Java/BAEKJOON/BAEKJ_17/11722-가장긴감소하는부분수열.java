import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n]; // n길이 dp
        StringTokenizer tr = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){ // 수열A 리스트
            arr[i] = Integer.parseInt(tr.nextToken());
        }
        Arrays.fill(dp, 1); // dp끝까지 초기에 1로 초기화
        for(int i = 0; i < n; i++) { // arr 처음부터 하나씩 비교하며 dp채우기
            for(int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) { // arr[i]랑 arr[i]앞에 있는 요소들을 다 비교하면서 arr[i]보다 큰 값이 있으면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 그 위치에 저장된 dp값이랑 현재위치 dp값(1)을 더해서 현재위치에 저장
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) { // 마지막에 dp 전부 돌면서 가장 큰 값 출력
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);

    }
}
