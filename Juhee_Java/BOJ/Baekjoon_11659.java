package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11659 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        int[] list = new int[N + 1];
        int[] sum = new int[N + 1];
        int num = 0;

        for (int i = 1; i < N + 1; i++) {
            int temp = Integer.parseInt(st.nextToken());
            list[i] = temp;
            num += temp;
            sum[i] = num;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == B) {
                System.out.println(list[A]);
            } else {
                System.out.println(sum[B] - sum[A - 1]);
            }
        }
    }
}
