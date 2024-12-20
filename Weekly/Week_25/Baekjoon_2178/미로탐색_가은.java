import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for(int j=0; j<M; j++) {
                map[i][j] = a.charAt(j) - '0';
            }
        }

        bfs(0,0);
        bw.write(map[N-1][M-1]+"");

        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point currentPoint = q.poll();
            for(int i=0; i<4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue;
                if(map[nextX][nextY] == 0) continue;
                if(visited[nextX][nextY]) continue;

                q.add(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
}