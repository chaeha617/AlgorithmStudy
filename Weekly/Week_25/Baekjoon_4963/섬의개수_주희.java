import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수_주희 {
    static int[][] graph;
    static int[][] visited;
    static int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) {
                continue;
            }

            StringTokenizer st = new StringTokenizer(input);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0) {
                break;
            }

            graph = new int[y][x];
            visited = new int[y][x];

            for (int i = 0; i < y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    if (st.hasMoreTokens()) {
                        graph[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (graph[i][j] == 1 && visited[i][j] == 0) {
                        count ++;
                        bfs(j, i);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempY = temp[0];
            int tempX = temp[1];

            for (int i = 0; i < 8; i++) {
                int nx = tempX + dx[i];
                int ny = tempY + dy[i];
                if (nx >= 0 && ny >= 0 && nx < graph[0].length && ny < graph.length) {
                    if (graph[ny][nx] == 1 && visited[ny][nx] == 0) {
                        visited[ny][nx] = 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
