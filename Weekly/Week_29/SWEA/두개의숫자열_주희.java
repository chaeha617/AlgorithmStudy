package SWEA;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                int temp = sc.nextInt();
                A[i] = temp;
            }
            for (int i = 0; i < M; i++) {
                int temp = sc.nextInt();
                B[i] = temp;
            }

            if (N == M) {
                int answer = isSame(A, B);
                System.out.println("#" + test_case + " " + answer);
            } else if (N < M) {
                int answer = isNotSame(A, B);
                System.out.println("#" + test_case + " " + answer);
            } else {
                int answer = isNotSame(B, A);
                System.out.println("#" + test_case + " " + answer);
            }
        }
    }

    public static int isSame(int[] A, int[] B) {
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }
        return answer;
    }

    public static int isNotSame(int[] A, int[] B) {
        int max = 0;

        for (int i = 0; i < B.length - A.length + 1; i++) {
            int answer = 0;
            for (int j = 0; j < A.length; j++) {
                answer += A[j] * B[j+i];
            }
            if (answer > max) {
                max = answer;
            }
        }
        return max;
    }


}