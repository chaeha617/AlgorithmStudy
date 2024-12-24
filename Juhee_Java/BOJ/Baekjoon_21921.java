package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a != 0) {
                found = true;
            }
            list.add(a);
        }

        if (!found) {
            System.out.println("SAD");
        } else {
            int current = 0;
            for (int i = 0; i < X; i++) {
                current += list.get(i);
            }

            int max = current;
            int count = 1;

            for (int i = X; i < N; i++) {
                current += list.get(i) - list.get(i-X);
                if (current > max) {
                    count = 1;
                    max = current;
                } else if (current == max) {
                    count += 1;
                }
            }

            System.out.println(max);
            System.out.println(count);
        }
    }
}
