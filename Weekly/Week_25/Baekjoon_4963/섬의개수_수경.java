import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int w = temp[0];
            int h = temp[1];

            for (int l = 0; l < 8; l++) {
                int xx = w + dx[l];
                int yy = h + dy[l];

                if (xx < 0 || xx >= graph.length || yy < 0 || yy >= graph[0].length) continue;
                if (visited[xx][yy] || graph[xx][yy] == 0) continue;

                visited[xx][yy] = true;
                q.add(new int[]{xx, yy});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(tr.nextToken());
        int x = Integer.parseInt(tr.nextToken());
        while (x != 0 && y != 0) {
            int ans = 0;
            graph = new int[x][y];
            visited = new boolean[x][y];

            for (int i = 0; i < x; i++) {
                tr = new StringTokenizer(br.readLine());
                for (int j = 0; j < y; j++) {
                    graph[i][j] = Integer.parseInt(tr.nextToken());
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (visited[i][j] || graph[i][j] == 0) continue;
                    ans++;
                    bfs(i, j);
                }
            }
            System.out.println(ans);

            tr = new StringTokenizer(br.readLine());
            y = Integer.parseInt(tr.nextToken());
            x = Integer.parseInt(tr.nextToken());

            if (x == 0 && y == 0) break;
        }
    }
}
