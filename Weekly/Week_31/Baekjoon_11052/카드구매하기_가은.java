import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = arr[1]; // 초기값 설정 : 1단계

        for(int i=2; i<=N; i++) {
            for(int j=i-1; j>=0; j--) {
                dp[i] = Math.max(dp[i], arr[i-j]+dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}