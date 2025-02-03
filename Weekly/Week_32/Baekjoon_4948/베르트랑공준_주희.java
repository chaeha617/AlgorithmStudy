package Baekjoon_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 베르트랑공준_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            int[] list = new int[2*N + 1];
            for (int i = 2; i < 2*N + 1; i++) {
                list[i] = i;
            }

            for (int i = 2; i * i <= 2 * N; i++) {
                if (list[i] != 0) {
                    for (int j = i * i; j <= 2 * N; j += i) {
                        list[j] = 0;
                    }
                }
            }

            int count = 0;
            for (int i = N+1; i <= 2 * N; i++) {
                if (list[i] != 0) {
                    count += 1;
                }
            }
            System.out.println(count);
        }
    }
}
