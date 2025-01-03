package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChickenSortSteps {

    // 부분 문제 해결
    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }

    // 단계별 병합 과정 처리 함수
    public static void DivideAndConquer(List<List<Integer>> groups, int k) {
        while (groups.size() > 1) {
            List<List<Integer>> newGroups = new ArrayList<>();
            // 부분 문제 해결
            for (int i = 0; i < groups.size(); i += 2) {
                List<Integer> left = groups.get(i);
                List<Integer> right;
                if(i + 1 < groups.size())
                    right = groups.get(i + 1);
                else
                    right = new ArrayList<>();
                newGroups.add(merge(left, right));
            }

            //조합
            groups = newGroups;
            StringBuilder stringBuilder = new StringBuilder();
            if (groups.size() <= k) {
                for (List<Integer> group : groups) {
                    for (int num : group) {
                        System.out.print(num + " ");
                    }
                }
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        int N = Integer.parseInt(st.nextToken());
        List<Integer> scores = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores.add(Integer.parseInt(st.nextToken()));
        }
        int k = Integer.parseInt(br.readLine());

        //분할
        List<List<Integer>> groups = new ArrayList<>();
        for (int score : scores) {
            groups.add(Collections.singletonList(score));
        }


        DivideAndConquer(groups, k);

        br.close();
    }
}
