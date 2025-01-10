package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class 두개의숫자열_주희
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int temp = sc.nextInt();
                A.add(temp);
            }
            for (int i = 0; i < M; i++) {
                int temp = sc.nextInt();
                B.add(temp);
            }

            int sum = 0;
            if (N > M) {
                sum = solution(M, N, B, A);
            } else {
                sum  = solution(N, M, A, B);
            }

            System.out.println("#" + test_case + " " + sum);

        }
    }

    public static int solution(int N, int M, List<Integer> A, List<Integer> B) {
        int sum = 0;
        for (int i = 0; i < M-N+1; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                temp += A.get(j) * B.get(i+j);
            }
            if (temp > sum) {
                sum = temp;
            }
        }
        return sum;
    }


}