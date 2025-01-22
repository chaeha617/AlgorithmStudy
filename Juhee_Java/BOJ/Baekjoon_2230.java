package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2230 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            list[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;

        Arrays.sort(list);
        int min = Integer.MAX_VALUE;

        while (end < N) {
            int temp = list[end] - list[start];
            if (temp >= M) {
                min = Math.min(min, temp);
                start++;
            } else {
                end ++;
            }
            if (start == end) {
                end++;
            }
        }

        System.out.println(min);
    }
}
