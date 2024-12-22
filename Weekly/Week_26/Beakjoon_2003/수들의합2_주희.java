package Beakjoon_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2_주희 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, count = 0;

        while (end < N) {
            sum += list[end];

            while (sum > M) {
                sum -= list[start];
                start++;
            }

            if (sum == M) {
                count++;
            }

            end++;
        }

        System.out.println(count);
    }

}
