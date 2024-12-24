package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_15650 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        List<Integer> combination = new ArrayList<>();
        combi(list, combination, 0, M);
    }

    public static void combi(List<Integer> list, List<Integer> combination, int start, int M) {
        if (combination.size() == M) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            combination.add(list.get(i));
            combi(list, combination, i + 1, M);
            combination.remove(combination.size() - 1);
        }
    }
}
