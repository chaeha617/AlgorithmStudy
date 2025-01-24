import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] dp;

    public static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) return 1; // 도착지점이면 +1
        if (dp[x][y] != -1) return dp[x][y]; // 계산한 적이 있으면 그냥 리턴

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && graph[x][y] > graph[xx][yy]) {
                dp[x][y] += dfs(xx, yy);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tr.nextToken());
        m = Integer.parseInt(tr.nextToken());
        graph = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            tr = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(tr.nextToken());
                dp[i][j] = -1;
            }
        }

        int ans = dfs(0, 0);
        System.out.println(ans);
    }
}