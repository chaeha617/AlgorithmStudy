import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] caseAll = new int[N];

            for (int i = 0; i < N; i++) {
                caseAll[i] = sc.nextInt();
            }

            long answer = countMax(caseAll, N);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static long countMax(int[] caseAll, int N) {
        long profit = 0;
        int maxPrice = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (caseAll[i] > maxPrice) {
                maxPrice = caseAll[i];
            } else {
                profit += maxPrice - caseAll[i];
            }
        }
        return profit;
    }
}
