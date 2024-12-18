import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_주희 {
    static int[][] graph;
    static int[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(bufferedReader.readLine());

        int y = Integer.parseInt(tr.nextToken());
        int x = Integer.parseInt(tr.nextToken());

        graph = new int[y][x];
        visited = new int[y][x];

        for (int i = 0; i < y; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < x; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] != 0 && visited[i][j] == 0) {
                    bfs(j, i);
                }
            }
        }
        System.out.println(graph[y-1][x-1]);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempY = temp[0];
            int tempX = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = tempY + dy[i];
                int nx = tempX + dx[i];

                if (nx >= 0 && ny >= 0 && nx < graph[0].length && ny < graph.length) {
                    if (graph[ny][nx] != 0 && visited[ny][nx] == 0) {
                        visited[ny][nx] = 1;
                        graph[ny][nx] = graph[tempY][tempX] + 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

    }
}
