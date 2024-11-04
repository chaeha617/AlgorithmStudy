import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer tr = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){ // 배열 입력 받기
                arr[i] = Integer.parseInt(tr.nextToken());
            }

            int ans = 0, max;
            for(int i = 2; i < n - 2; i++){ // 양 끝 2개 빼고 탐색
                max = Math.max(arr[i - 1], arr[i - 2]); // 탐색하는 위치 왼쪽 두 칸 중 큰 값 저장
                max = Math.max(max, Math.max(arr[i + 1], arr[i + 2])); // 위에서 저장한 max값과 탐색위치 오른쪽 두 칸 중 큰 값 비교 후 더 큰 값 저장
                if(arr[i] > max) { // 탐색위치가 max보다 클 때
                    ans += (arr[i] - max); // arr[i] - max(확보된 조망권)을 ans에 저장
                }
            }
            System.out.println("#" + (t + 1) + " " + ans);

        }
    }
}