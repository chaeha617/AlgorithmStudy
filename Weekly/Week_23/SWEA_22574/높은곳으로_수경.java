import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int ans = 0;
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tr.nextToken());
            int m = Integer.parseInt(tr.nextToken());

            for(int i = 1; i < n + 1; i++){
                ans += i;
                if(ans == m) ans--;
            }
            System.out.println(ans);
        }
    }
}
