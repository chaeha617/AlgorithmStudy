import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> arr = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            arr.addLast(Integer.parseInt(st.nextToken()));
        }

        String answer = "Nice";
        Deque<Integer> line = new ArrayDeque<>();

        line.addLast(arr.pollFirst());
        for(int i=1; i<=N; i++) {
            while (!arr.isEmpty()) {
                if(!line.isEmpty() && line.peekLast() < arr.peekFirst()) break;
                line.addLast(arr.pollFirst());
            }
            if(line.pollLast() != i) {
                answer = "Sad";
                break;
            }
        }

        System.out.println(answer);
    }
}