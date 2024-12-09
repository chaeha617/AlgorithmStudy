import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> card = new PriorityQueue<>();
        int answer = 0;

        for(int i=0; i<N; i++) {
            card.add(Integer.parseInt(br.readLine()));
        }

        if(N==1) bw.write("0\n");
        else {
            for (int i=1; i<N; i++) {
                int a = card.poll() + card.poll();
                answer += a;
                card.add(a);
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}