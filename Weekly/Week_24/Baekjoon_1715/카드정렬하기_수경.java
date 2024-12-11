import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 빠르게 받기 위한 BufferedReader
        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int t = 0; t < T; t++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            ans += sum;
            pq.add(sum);
        }
        System.out.println(ans);
    }
}