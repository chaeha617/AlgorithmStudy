package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표정렬하기2 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            List<Integer> temp = new ArrayList<>();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            temp.add(a);
            temp.add(b);
            list.add(temp);
        }

        Collections.sort(list, (a, b) -> {
            if (a.get(1).equals(b.get(1))) {
                return a.get(0) - b.get(0);
            }
            return a.get(1) - b.get(1);
        });

        for (List<Integer> a : list) {
            for (int n : a) {
                System.out.print(n + " ");
            }
            System.out.println();

        }
    }
}
