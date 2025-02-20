import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int ans = 1;
        boolean virus = false;
        while (!q.isEmpty()) {
            int[] next = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = next[0] + dx[i];
                int yy = next[1] + dy[i];
                if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
                if (graph[xx][yy] == 1 || visited[xx][yy]) continue;
                if (graph[xx][yy] == 2) {
                    virus = true;
                    continue;
                }
                q.add(new int[]{xx, yy});
                ans++;
                visited[xx][yy] = true;
            }
        }
        if (virus) return 0;
        return ans;
    }

    public static int back(int depth, int x, int y) {
        int ans = 0;
        for (int i = x; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == x && j < y) continue;
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    depth += 1;
                    if (depth == 3) {
                        ans = Math.max(safe(), ans);
                    } else {
                        ans = Math.max(ans, back(depth, i, j));
                    }
                    depth -= 1;
                    graph[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static int safe() {
        visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    ans += bfs(i, j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tr.nextToken());
        m = Integer.parseInt(tr.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            tr = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(tr.nextToken());
            }
        }

        System.out.println(back(0, 0, 0));
    }
}