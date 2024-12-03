import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for(int t= 0; t < T; t++){
            String commandStr = br.readLine();
            int num = 0;
            if(commandStr.startsWith("1") || commandStr.startsWith("2")) {
                String[] cmArr = commandStr.split(" ");
                commandStr = cmArr[0];
                num = Integer.parseInt(cmArr[1]);
            }
            switch (commandStr) {
                case "1":
                    deque.addFirst(num);
                    continue;
                case "2":
                    deque.addLast(num);
                    continue;
                case "3":
                    if(deque.isEmpty()) bw.write("-1" + "\n");
                    else bw.write(deque.removeFirst() + "\n");
                    continue;
                case "4":
                    if(deque.isEmpty()) bw.write("-1" + "\n");
                    else bw.write(deque.removeLast() + "\n");
                    continue;
                case "5":
                    bw.write(deque.size() + "\n");
                    continue;
                case "6":
                    if(deque.isEmpty()) bw.write("1" + "\n");
                    else bw.write("0" + "\n");
                    continue;
                case "7":
                    if(deque.isEmpty()) bw.write("-1" + "\n");
                    else bw.write(deque.peekFirst() + "\n");
                    continue;
                case "8":
                    if(deque.isEmpty()) bw.write("-1" + "\n");
                    else bw.write(deque.peekLast() + "\n");
            }
        }
        bw.flush();
    }
}