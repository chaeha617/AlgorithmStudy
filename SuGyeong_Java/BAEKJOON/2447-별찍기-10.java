import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;
    static int[] dx = {0, 1, 2, 2, 2, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, 2, 2, 2, 1};

    public static void star(int n, int x, int y) {
        if (n == 3) { // n이 3이면 가운데 빼고 가장자리 8군데를 8로 채워줌
            for (int i = 0; i < 8; i++) {
                graph[x + dx[i]][y + dy[i]] = '*';
            }
            return;
        }
        n = n / 3; // 입력받은 n을 3이 될때까지 나눠주면서 재귀 반복
        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i] * n;
            int yy = y + dy[i] * n;
            star(n, xx, yy);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        graph = new char[n][n]; // NxN크기의 배열을 만들어서
        for (int i = 0; i < n; i++) { // 일단 배열 전부를 공백(' ')으로 채워줌
            Arrays.fill(graph[i], ' ');
        }
        star(n, 0, 0);
        for (int i = 0; i < n; i++) { // star()에서 별로 채워진 배열을 BufferedWriter에 반복문으로 저장해서
            for (int j = 0; j < n; j++) {
                bw.write(graph[i][j]);
            }
            bw.write("\n");
        }
        bw.flush(); // 한 번에 출력
    }
}