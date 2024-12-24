package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int T = Integer.parseInt(st.nextToken());
            int count = 0;
            ArrayList<Integer> student = new ArrayList<>();

            for (int j = 0; j < 20; j++) {
                int a = Integer.parseInt(st.nextToken());
                int index = 0;

                for (int s : student) {
                    if (s > a) {
                        break;
                    }
                    index++;
                }

                count += student.size() - index;
                student.add(index, a);
            }

            System.out.println(T + " " + count);
        }
    }
}
