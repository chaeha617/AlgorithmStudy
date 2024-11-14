// 1
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

// 2(수정)
import java.util.*;
import java.io.*;

public class Main {
    static Queue<Integer> queue1;
    static Queue<Integer> queue2;

    public static void Insert(int k, int[] arr) {
        for(int i = 0; i < k; i++){
            queue2.add(queue1.poll());
        }
        for(int i = 0; i < arr.length; i++){
            queue2.add(arr[i]);
        }

        int queueSize = queue1.size();
        for(int i = 0; i < queueSize; i++){
            queue2.add(queue1.poll());
        }
        queue1 = new LinkedList<>(queue2);
        queue2 = new LinkedList<>();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t++) {
            int n = Integer.parseInt(br.readLine());
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();

            StringTokenizer tr = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                queue1.add(Integer.parseInt(tr.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            tr = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                String s = tr.nextToken();
                int k = Integer.parseInt(tr.nextToken());
                int l = Integer.parseInt(tr.nextToken());
                if (s.equals("I")) {
                    int[] arr = new int[l];
                    for (int j = 0; j < l; j++) {
                        arr[j] = Integer.parseInt(tr.nextToken());
                    }
                    Insert(k, arr);
                }
            }
            System.out.print("#" + (t + 1) + " ");
            for(int i = 0; i < 10; i++){
                System.out.print(queue1.poll() + " ");
            }
            System.out.println();
        }
    }
}
