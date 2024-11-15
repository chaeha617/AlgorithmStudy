import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tr.nextToken());
            int m = Integer.parseInt(tr.nextToken());
            boolean[] booleans = new boolean[n + 1];
            tr = new StringTokenizer(br.readLine());
            for(int i = 1; i < m + 1; i++){
                booleans[Integer.parseInt(tr.nextToken())] = true;
            }
            System.out.print("#" + (t + 1) + " ");
            for(int i = 1; i < n + 1; i++){
                if(!booleans[i]) System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}