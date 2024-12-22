import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 고양이카페_주희 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int start = 0;
        int end = list.size()-1;
        int count = 0;

        while (start < end) {
            if (list.get(start) + list.get(end) <= K) {
                count += 1;
                start += 1;
                end -= 1;
            }

            if (list.get(start) + list.get(end) > K) {
                end -= 1;
            }
        }
        System.out.println(count);

    }
}
