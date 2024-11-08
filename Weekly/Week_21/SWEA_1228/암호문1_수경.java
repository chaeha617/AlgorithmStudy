import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t++){
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> tempQ = new LinkedList<>();

            int n = Integer.parseInt(br.readLine());
            StringTokenizer tr = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++) {
                queue.offer(Integer.parseInt(tr.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            tr = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                String str = tr.nextToken();
                int x = Integer.parseInt(tr.nextToken());
                int num = Integer.parseInt(tr.nextToken());
                if(i % 2 == 0){ // 명령마다 번갈아가면서 tempQ 혹은 queue 이용
                    for(int j = 0; j < x; j++){
                        tempQ.offer(queue.poll());
                    }
                    for(int j = 0; j < num; j++){
                        tempQ.offer(Integer.parseInt(tr.nextToken()));
                    }
                    int queueSize = queue.size();
                    for(int j = 0; j < queueSize; j++){
                        tempQ.offer(queue.poll());
                    }
                } else {
                    for(int j = 0; j < x; j++){
                        queue.offer(tempQ.poll());
                    }
                    for(int j = 0; j < num; j++){
                        queue.offer(Integer.parseInt(tr.nextToken()));
                    }
                    int tempQSize = tempQ.size();
                    for(int j = 0; j < tempQSize; j++){
                        queue.offer(tempQ.poll());
                    }
                }
            }
            System.out.print("#" + (t + 1) + " ");
            if(m % 2 != 0) {
                for(int i = 0; i < 10; i++){
                    System.out.print(tempQ.poll() + " ");
                }
            } else {
                for(int i = 0; i < 10; i++){
                    System.out.print(queue.poll() + " ");
                }
            }
            System.out.println();
        }
    }
}