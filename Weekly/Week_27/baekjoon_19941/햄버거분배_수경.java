import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tr.nextToken());
        int k = Integer.parseInt(tr.nextToken());
        String str = br.readLine();

        char[] strArr = str.toCharArray(); // str -> char[]
        boolean[] used = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (strArr[i] == 'P') {
                for (int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                    if (strArr[j] == 'H' && !used[j]) { // false인 H를 찾으면
                        used[j] = true; // 해당 H를 사용 처리
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
