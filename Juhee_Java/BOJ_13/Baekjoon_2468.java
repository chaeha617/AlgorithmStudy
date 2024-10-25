package BOJ_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2468 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int maxCount = 0;

        for(int c = 0; c <= 100; c++) {
            int count = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > c && !visited[i][j]) {
                        dfs(i,j,c);
                        count ++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }

        }
        System.out.println(maxCount);
    }


    public static void dfs(int x, int y, int c) {
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || arr[x][y] <= c) {
            return;
        }

        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, c);
        }
    }
}
