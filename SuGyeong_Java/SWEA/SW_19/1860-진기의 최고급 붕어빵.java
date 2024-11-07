import java.io.*;
import java.util.*;

public class Main {
    public static int possible(int[] arr, int n, int m, int k) {
        if(arr[0] < m) {
            return 0;
        } else {
            for(int i = 0; i < n; i++){
                int num = arr[i] / m;
                int num2 = num * k;
                if(num2 < i + 1) {
                    return 0;
                }
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tr.nextToken());
            int m = Integer.parseInt(tr.nextToken());
            int k = Integer.parseInt(tr.nextToken());

            int[] arr = new int[n];
            tr = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(tr.nextToken());
            } Arrays.sort(arr);

            if(possible(arr, n, m, k) == 0){
                System.out.println("#" + (t + 1) + " " + "Impossible");
            }else System.out.println("#" + (t + 1) + " " + "Possible");
        }
    }
}
