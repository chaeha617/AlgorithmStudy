import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0}; // 0: 위, 1: 오, 2: 아래, 3: 왼
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tr.nextToken());
        int m = Integer.parseInt(tr.nextToken());

        tr = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(tr.nextToken());
        int c = Integer.parseInt(tr.nextToken());
        int direc = Integer.parseInt(tr.nextToken());

        int[][] graph = new int[n][m];
        for(int i = 0; i < n; i++){
            tr = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(tr.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0}; // 0: 위, 1: 오, 2: 아래, 3: 왼
        int[] dy = {0, 1, 0, -1};
        int ans = 0;
        while(true){
            if(graph[r][c] == 0){ // 현재 칸이 청소되지 않은 칸이면 -1로 청소했다는 표시, ans + 1;
                graph[r][c] = -1;
                ans++;
            }
            boolean clean = true;
            for(int i = 0; i < 4; i++){ // 주변 4칸 중 청소되지 않은 칸이 있는지 확인
                if(graph[r + dx[i]][c + dy[i]] == 0) {
                    clean = false;
                }
            }

            if(clean){ // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                if(graph[r - dx[direc % 4]][c - dy[direc % 4]] == 1) break;
                else {
                    r -= dx[direc % 4];
                    c -= dy[direc % 4];
                }
            } else { // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                direc--;
                if(direc < 0) direc = 3;

                if(graph[r + dx[direc % 4]][c + dy[direc % 4]] == 0){
                    r += dx[direc % 4];
                    c += dy[direc % 4];
                }
            }
        }
        System.out.println(ans);
    }
}