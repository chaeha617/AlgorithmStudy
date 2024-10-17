import java.io.*; // 입출력 처리를 위한 java.io 패키지 임포트
import java.util.*; // 문자열 분리 등을 위한 java.util 패키지 임포트

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 n(동전의 종류)과 k(만들고자 하는 금액)를 입력받음
        StringTokenizer tr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tr.nextToken()); // 동전의 종류 개수
        int k = Integer.parseInt(tr.nextToken()); // 목표 금액

        // n개의 동전 가치를 저장할 배열 선언
        int[] arr = new int[n];

        // 동전으로 만들 수 있는 경우의 수를 저장할 dp 배열 선언
        // dp[j]는 j원을 만들 수 있는 경우의 수를 저장
        int[] dp = new int[k + 1];

        // 초기 조건: 0원을 만들 수 있는 경우의 수는 1가지 (동전을 사용하지 않는 경우)
        dp[0] = 1;

        // 동전의 가치 입력 받기
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 동전의 가치를 오름차순으로 정렬 (정렬은 필수는 아니지만, 동전이 작은 값부터 적용되도록 하기 위해)
        Arrays.sort(arr);

        // 동전마다 dp 배열을 업데이트하며 경우의 수를 계산
        for (int i = 0; i < n; i++) {
            // arr[i] 동전으로 만들 수 있는 금액부터 시작해서 k까지의 경우의 수를 업데이트
            for (int j = arr[i]; j < k + 1; j++) {
                // j원을 만들 수 있는 경우의 수는
                // "j - arr[i]"원을 만든 후에 arr[i] 동전을 추가하는 방식으로 계산 가능
                dp[j] += dp[j - arr[i]];
            }
        }

        // 최종적으로 dp[k]에 저장된 값이 k원을 만들 수 있는 모든 경우의 수
        System.out.println(dp[k]);
    }
}
