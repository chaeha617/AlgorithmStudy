import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static int bfs(int x, int y) {
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int ans = Integer.MAX_VALUE;

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int w = temp[0];
            int h = temp[1];

            for(int i = 0; i < 4; i++){
                int xx = w + dx[i];
                int yy = h + dy[i];

                if(xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
                if(visited[xx][yy] != 0 || graph[xx][yy] == 0) continue;
                if(xx == (n - 1) && yy == (m - 1)) {
                    return visited[w][h] + 1;
                }

                visited[xx][yy] = visited[w][h] + 1;
                queue.add(new int[]{xx, yy});
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
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        visited = new int[n][m];
        int ans = bfs(0,0);
        System.out.println(ans);
    }
}
