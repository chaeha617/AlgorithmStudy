import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_주희 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            minHeap.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int totalCost = 0;

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int sum = first + second;
            totalCost += sum;
            minHeap.add(sum);
        }

        System.out.println(totalCost);
    }
}
