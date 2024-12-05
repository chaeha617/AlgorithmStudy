import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> arr = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("1")) {
                arr.addFirst(Integer.parseInt(command[1]));
            } else if (command[0].equals("2")) {
                arr.addLast(Integer.parseInt(command[1]));
            } else if (command[0].equals("3")) {
                bw.write((arr.isEmpty() ? "-1" : arr.pollFirst()) + "\n");
            } else if (command[0].equals("4")) {
                bw.write((arr.isEmpty() ? "-1" : arr.pollLast()) + "\n");
            } else if (command[0].equals("5")) {
                bw.write(arr.size() + "\n");
            } else if (command[0].equals("6")) {
                bw.write((arr.isEmpty() ? "1" : "0") + "\n");
            } else if (command[0].equals("7")) {
                bw.write((arr.isEmpty() ? "-1" : arr.peekFirst()) + "\n");
            } else if (command[0].equals("8")) {
                bw.write((arr.isEmpty() ? "-1" : arr.peekLast()) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}