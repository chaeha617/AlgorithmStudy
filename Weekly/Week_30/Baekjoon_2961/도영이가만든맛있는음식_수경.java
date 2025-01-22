import java.io.*;
import java.util.*;

public class Main {
    static int n, ans;
    static int[] sourArr, bitterArr;

    public static void cook(int depth, int sour, int bitter, boolean[] visited) {
        if (depth > 0) {
            int temp = Math.abs(sour - bitter);
            ans = Math.min(ans, temp);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cook(depth + 1, sour * sourArr[i], bitter + bitterArr[i], visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sourArr = new int[n];
        bitterArr = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tr = new StringTokenizer(br.readLine());
            sourArr[i] = Integer.parseInt(tr.nextToken());
            bitterArr[i] = Integer.parseInt(tr.nextToken());
        }

        ans = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];

        cook(0, 1, 0, visited);
        System.out.println(ans);
    }
}
