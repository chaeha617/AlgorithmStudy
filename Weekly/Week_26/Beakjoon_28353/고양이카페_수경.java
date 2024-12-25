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
        Arrays.sort(arr);

        int left = 0, right = n - 1, sum, count = 0;

        while (left < right) {
            sum = arr[left] + arr[right];

            if(sum <= m) {
                count++;
                left++;
                right--;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
