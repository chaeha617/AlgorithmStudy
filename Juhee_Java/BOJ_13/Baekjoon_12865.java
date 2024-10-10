// 평범한 배낭
package BOJ_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_12865 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 물품 수
        int K = scanner.nextInt(); // 버틸 수 있는 무게

        ArrayList<int[]> bag = new ArrayList<>();
        int[] dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            bag.add(new int[]{A, B}); // 무게, 가치
        }

        for(int i = 0; i < N; i++){
            int weight = bag.get(i)[0];
            int value = bag.get(i)[1];

            for(int j = K; j >= weight; j--){
                dp[j] = Math.max(dp[j], dp[j-weight]+value);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }

}