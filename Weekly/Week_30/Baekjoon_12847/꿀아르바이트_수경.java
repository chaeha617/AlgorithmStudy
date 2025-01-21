import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tr.nextToken());
        int m = Integer.parseInt(tr.nextToken());
        int[] arr = new int[n];

        tr = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tr.nextToken());
        }

        if (m == 0) {
            System.out.println(0);
            return;
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        long maxSum = sum;

        for (int i = m; i < n; i++) {
            sum += arr[i] - arr[i - m];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}