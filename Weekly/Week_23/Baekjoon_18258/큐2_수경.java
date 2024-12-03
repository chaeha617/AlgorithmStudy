import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int t = Integer.parseInt(br.readLine());
        int temp;
        int last = -1;

        for(int i = 0; i < t; i++) {
            String str = br.readLine();

            if (str.startsWith("push")) {
                last = Integer.parseInt(str.split(" ")[1]);
                queue.add(last);

            } else if (str.equals("pop")) {
                if (!queue.isEmpty()) temp = queue.poll();
                else temp = -1;
                bw.write(temp + "\n");

            } else if (str.equals("size")) {
                bw.write(queue.size() + "\n");

            } else if (str.equals("empty")) {
                if(queue.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");

            } else if (str.equals("front")) {
                if (!queue.isEmpty()) temp = queue.peek();
                else temp = -1;
                bw.write(temp + "\n");

            } else if (str.equals("back")) {
                if (!queue.isEmpty()) bw.write(last + "\n");
                else bw.write(-1 + "\n");
            }
        }
        bw.flush();
    }
}
