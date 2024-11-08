import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t++){
            int T = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer tr = new StringTokenizer(br.readLine());
            for(int i = 0; i < 8; i++){
                q.add(Integer.parseInt(tr.nextToken()));
            }
            int temp = 1;
            int i = 1;
            while (temp != 0){
                if(i == 6) i = 1;
                temp = q.poll();
                temp = Math.max(0, temp - i);
                q.offer(temp);
                i++;
            }
            System.out.print("#" + T + " ");
            for(int j = 0; j < 8; j++){
                System.out.print(q.poll() + " ");
            }
            System.out.println();
        }
    }
}