import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> arr = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> arrInt = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            arrInt.add(arr.poll());
        }

        int answer = 0;
        if(arrInt.size() > 2) {
            answer = countAnswer(arrInt, K);
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    static int countAnswer(Deque<Integer> arrInt, int K) {
        int start = arrInt.pollFirst();
        int end = arrInt.pollLast();
        int answer = 0;

        while (true) {
            if(start+end <= K) {
                answer++;
                if(arrInt.size() >= 2) {
                    start = arrInt.pollFirst();
                    end = arrInt.pollLast();
                } else break;
            } else {
                if(arrInt.size() >= 1) {
                    end = arrInt.pollLast();
                } else break;
            }
        }

        return answer;
    }
}
