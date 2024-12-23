import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스선물_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1, o2);
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) {
                if (maxHeap.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(maxHeap.poll());
                }
            } else {
                for (int j = 0; j < input; j++) {
                    maxHeap.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}
