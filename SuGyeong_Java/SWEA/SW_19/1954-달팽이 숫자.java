import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}; // x축 이동 배열 (오른쪽, 아래, 왼쪽, 위)
    static int[] dy = {1, 0, -1, 0}; // y축 이동 배열 (오른쪽, 아래, 왼쪽, 위)

    public static void dfs(int x, int y, int direction, int depth) {
        arr[x][y] = depth; // 현재 위치에 depth 값을 저장 (이동 순서)

        if (depth == n * n) return;

        // 현재 방향으로 한 칸 이동
        int xx = x + dx[direction];
        int yy = y + dy[direction];

        // 범위를 벗어나거나 이미 채워진 경우, 방향을 바꿔서 다시 이동
        if (xx < 0 || xx >= n || yy < 0 || yy >= n || arr[xx][yy] != 0) {
            direction = (direction + 1) % 4; // 방향을 오른쪽으로 회전
            xx = x + dx[direction];
            yy = y + dy[direction];
        }

        // 다음 칸으로 재귀 호출
        dfs(xx, yy, direction, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            dfs(0, 0, 0, 1); // (0,0) 위치에서 시작, 초기 방향은 오른쪽, 시작 깊이는 1

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