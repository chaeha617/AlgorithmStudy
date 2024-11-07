import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void dfs(int x, int y, int direction, int depth) {
        arr[x][y] = depth;
        if (depth == n * n) return;
        int xx = x + dx[direction];
        int yy = y + dy[direction];
        if (xx < 0 || xx >= n || yy < 0 || yy >= n) {
            direction = (direction + 1) % 4;
            xx = x + dx[direction];
            yy = y + dy[direction];
            dfs(xx, yy, direction, depth + 1);
            return;
        }
        if (arr[xx][yy] != 0) {
            direction = (direction + 1) % 4;
            xx = x + dx[direction];
            yy = y + dy[direction];
            dfs(xx, yy, direction, depth + 1);
            return;
        }
        dfs(xx, yy, direction, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            dfs(0, 0, 0, 1);
            System.out.println("#" + (t + 1));
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}