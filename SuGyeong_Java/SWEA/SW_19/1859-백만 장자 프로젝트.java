import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            StringTokenizer tr = new StringTokenizer(br.readLine());

            // 입력된 값을 배열에 역순으로 저장
            for(int j = n - 1; j >= 0; j--){
                arr[j] = Integer.parseInt(tr.nextToken());
            }

            long max = 0; // 현재까지의 최대값
            long ans = 0; // 최대 이익을 저장할 변수

            for(int i = 0; i < n; i++){
                max = Math.max(max, arr[i]); // 최대값 갱신

                // 현재 값이 최대값보다 작으면, 차이만큼 이익에 추가
                if(arr[i] < max) {
                    ans += max - arr[i];
                }
            }
            bw.write("#" + (t + 1) + " " + ans + "\n");
        }
        bw.flush(); // 출력 버퍼에 있는 내용을 모두 출력
    }
}