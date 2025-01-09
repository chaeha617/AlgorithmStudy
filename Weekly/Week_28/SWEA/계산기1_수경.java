import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            int ans = 0;
            for(int i = 0; i < n; i++){
                if(str.charAt(i) != '+') ans += Character.getNumericValue(str.charAt(i));
            }
            bw.write("#" + (t + 1) + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}