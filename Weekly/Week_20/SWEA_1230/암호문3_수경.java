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

    public static void Delete(int k, int l) {
        for(int i = 0; i < k; i++){
            queue2.add(queue1.poll());
        }
        for(int i = 0; i < l; i++){
            queue1.remove();
        }

        int queueSize = queue1.size();
        for(int i = 0; i < queueSize; i++){
            queue2.add(queue1.poll());
        }

        queue1 = new LinkedList<>(queue2);
        queue2 = new LinkedList<>();
    }

    public static void Add(int[] arr){
        for(int i = 0; i < arr.length; i++){
            queue1.add(arr[i]);
        }
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
                if (s.equals("I")) {
                    int k = Integer.parseInt(tr.nextToken());
                    int l = Integer.parseInt(tr.nextToken());
                    int[] arr = new int[l];
                    for (int j = 0; j < l; j++) {
                        arr[j] = Integer.parseInt(tr.nextToken());
                    }
                    Insert(k, arr);
                } else if (s.equals("D")) {
                    int k = Integer.parseInt(tr.nextToken());
                    int l = Integer.parseInt(tr.nextToken());
                    Delete(k, l);
                } else if (s.equals("A")) {
                    int l = Integer.parseInt(tr.nextToken());
                    int[] arr = new int[l];
                    for (int j = 0; j < l; j++) {
                        arr[j] = Integer.parseInt(tr.nextToken());
                    }
                    Add(arr);
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
