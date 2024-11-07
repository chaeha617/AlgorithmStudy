import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            StringTokenizer tr = new StringTokenizer(br.readLine());
            for(int j = n - 1; j >= 0; j--){
                arr[j] = Integer.parseInt(tr.nextToken());
            }

            long max = 0, ans = 0;
            for(int i = 0; i < n; i++){
                max = Math.max(max, arr[i]);
                if(arr[i] > max){
                    max = arr[i];
                } else if(arr[i] < max) {
                    ans += max - arr[i];
                }
            }
            bw.write("#" + (t + 1) + " " + ans + "\n");
        }
        bw.flush();
    }
}