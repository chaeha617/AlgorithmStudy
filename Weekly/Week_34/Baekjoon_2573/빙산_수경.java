import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void iceberg (int x, int y) {
        int count = 0;
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(graph[xx][yy] == 0) count += 1;
        }

        if(count >= graph[x][y]) {
            for(int i = 0; i < 2; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];

                if(graph[xx][yy] != 0) graph[xx][yy] += 1;
            }
        }
        graph[x][y] = Math.max(0, graph[x][y] - count);
    }

    public static void dfs (int x, int y, boolean[][] visited) {
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(graph[xx][yy] == 0 || visited[xx][yy]) continue;

            visited[xx][yy] = true;
            dfs(xx, yy ,visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tr.nextToken());
        m = Integer.parseInt(tr.nextToken());
        graph = new int[n][m];

        for(int i = 0; i < n; i++){
            tr = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(tr.nextToken());
            }
        }

        int ans, time = 0;
        while(true) {
            time++;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(graph[i][j] != 0){
                        iceberg(i, j);
                    }
                }
            }

            boolean[][] visited = new boolean[n][m];
            ans = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(graph[i][j] != 0 && !visited[i][j]){
                        ans++;
                        visited[i][j] = true;
                        dfs(i, j, visited);
                    }
                }
            }

            if(ans == 0 || ans > 1) break;
        }

        if(ans == 0) System.out.println(0);
        else System.out.println(time);
    }
}