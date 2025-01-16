package Baekjoon_15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class N과M6_주희 {
    static Set<List<Integer>> temp;
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            list.add(t);
        }

        Collections.sort(list);
        List<Integer> combination = new ArrayList<>();
        solution(list, combination, M, 0);

    }

    public static void solution(List<Integer> list, List<Integer> combination, int M, int start) {
        if (combination.size() == M) {
            for (int i = 0; i < combination.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(combination.get(i));
            }
            System.out.println();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            combination.add(list.get(i));
            solution(list, combination, M, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

}
