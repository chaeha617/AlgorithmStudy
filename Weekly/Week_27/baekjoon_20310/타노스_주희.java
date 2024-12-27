package baekjoon_20310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 타노스_주희 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        List<Integer> list = new ArrayList<>();

        int count0 = 0;
        int count1 = 0;

        for (char l : line.toCharArray()) {
            if (l == '0') {
                list.add(0);
                count0 += 1;
            }
            if (l == '1') {
                list.add(1);
                count1 += 1;
            }
        }
        int result0 = count0 / 2;
        int result1 = count1 / 2;

        for (int i = 0; i < result0; i++) {
            int idx = list.lastIndexOf(0);
            list.remove(idx);
        }
        for (int i = 0; i < result1; i++) {
            int idx = list.indexOf(1);
            list.remove(idx);
        }

        String answer = "";
        for (int i : list) {
            answer += i;
        }
        System.out.println(answer);

    }
}