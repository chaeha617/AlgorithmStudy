import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 빠르게 받기 위한 BufferedReader
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(str.equals("0")) {
                if(pq.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                String[] strArr = str.split(" ");
                for(int j = 0; j < Integer.parseInt(strArr[0]); j++){
                    pq.add(Integer.parseInt(strArr[j + 1]));
                }
            }
        }
    }
}