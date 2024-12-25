import java.io.*;
import java.util.*;

class Main {
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

        int left = 0, right = 0, sum = 0, count = 0;

        while (right < n) {
            sum += arr[right];
            while (sum > m) {
                sum -= arr[left];
                left++;
            }

            if (sum == m) {
                count++;
            }
            right++;
        }

        System.out.println(count);
    }
}
