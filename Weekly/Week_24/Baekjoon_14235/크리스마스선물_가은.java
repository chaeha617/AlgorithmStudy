import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> present = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            int visit = sc.nextInt();
            if(visit == 0) {
                if(present.isEmpty()) { System.out.println(-1); }
                else { System.out.println(present.poll()); }
            }
            else {
                for(int j=0; j<visit; j++) {
                    present.add(sc.nextInt());
                }
            }
        }
    }
}