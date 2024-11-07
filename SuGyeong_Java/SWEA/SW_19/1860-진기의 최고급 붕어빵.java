import java.io.*;
import java.util.*;

public class Main {
    public static int possible(int[] arr, int n, int m, int k) {
        if(arr[0] < m) { // 가장 빨리 도착하는 사람이 붕어빵을 만들기 전이라면 실패
            return 0; // 실패 시 0 리턴
        } else {
            for(int i = 0; i < n; i++){ // 모든 사람의 도착 시간에 대해 확인
                int num = arr[i] / m; // 현재 시간까지 만든 붕어빵의 세트 수 (도착 시간 / 붕어빵 제작 시간)
                int num2 = num * k; // 도착 시간까지 만든 총 붕어빵 수 (세트 수 * 세트당 붕어빵 수)

                // 도착한 사람의 순서보다 붕어빵이 부족하면 실패
                if(num2 < i + 1) {
                    return 0;
                }
            }
            return 1; // 성공 시 1 리턴
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for(int t = 0; t < T; t++){
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tr.nextToken());
            int m = Integer.parseInt(tr.nextToken());
            int k = Integer.parseInt(tr.nextToken());

            int[] arr = new int[n]; // 사람들이 도착하는 시간 저장 배열
            tr = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(tr.nextToken());
            }
            Arrays.sort(arr); // 도착 시간을 오름차순 정렬하여 가장 빨리 도착하는 사람부터 확인

            if(possible(arr, n, m, k) == 0) { // 실패하면 "Impossible" 출력
                System.out.println("#" + (t + 1) + " " + "Impossible");
            } else { // 성공하면 "Possible" 출력
                System.out.println("#" + (t + 1) + " " + "Possible");
            }
        }
    }
}
