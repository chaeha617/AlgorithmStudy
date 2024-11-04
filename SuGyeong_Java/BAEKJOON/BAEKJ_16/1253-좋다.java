import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 N개의 수의 개수 입력 받음
        int n = Integer.parseInt(br.readLine());

        // 입력받은 N개의 수를 저장할 배열 선언
        int[] arr = new int[n];

        // 좋은 수의 개수를 저장할 변수, 투 포인터(left, right)를 초기화
        int count = 0, left = 0, right = arr.length - 1;

        // 두 번째 줄에서 N개의 숫자를 입력받고 배열에 저장
        StringTokenizer tr = new StringTokenizer(br.readLine());

        // 배열에 숫자들을 저장
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tr.nextToken());
        }

        // 배열을 오름차순으로 정렬 (이진 탐색과 투 포인터를 사용하기 위해)
        Arrays.sort(arr);

        // 배열의 각 숫자를 순차적으로 확인 (i번째 수가 좋은 수인지 확인)
        for(int i = 0; i < n; i++){
            int target = arr[i]; // 현재 검사할 숫자를 target으로 설정
            while (left < right){
                int sum = arr[left] + arr[right]; // 두 수의 합을 계산
                if (sum < target) {
                    left += 1; // 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 이동
                } else if(sum > target) {
                    right -= 1; // 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 이동
                } else if (left == i) {
                    left += 1; // 만약 왼쪽 포인터가 현재 target과 같은 인덱스라면, 포인터를 옮김
                } else if (right == i) {
                    right -= 1; // 만약 오른쪽 포인터가 현재 target과 같은 인덱스라면, 포인터를 옮김
                } else {
                    count += 1; // 두 수의 합이 target과 같으면 좋은 수이므로 카운트를 증가
                    break; // 더 이상 확인할 필요가 없으므로 while문을 탈출
                }
            }
            // 다음 target을 확인하기 전에 투 포인터를 초기 상태로 되돌림
            left = 0;
            right = arr.length - 1;
        }

        // 최종적으로 찾은 좋은 수의 개수를 출력
        System.out.println(count);
    }
}
