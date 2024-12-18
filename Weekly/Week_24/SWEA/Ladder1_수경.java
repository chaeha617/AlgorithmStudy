import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;

    public static int Ladder(int x, int y) {
        int xx = x;
        int yy = y;

        while (xx > 0) {
            if ((yy - 1) >= 0 && graph[xx][yy - 1] == 1) {
                while ((yy - 1) >= 0 && graph[xx][yy - 1] == 1) {
                    yy--;
                }
            } else if ((yy + 1) < 100 && graph[xx][yy + 1] == 1) {
                while ((yy + 1) < 100 && graph[xx][yy + 1] == 1) {
                    yy++;
                }
            }
            xx--;
        }
        return yy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 0; t < 10; t++){
            int T = Integer.parseInt(br.readLine());
            graph = new int[100][100];

            for(int i = 0; i < 100; i++){
                StringTokenizer tr = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    graph[i][j] = Integer.parseInt(tr.nextToken());
                }
            }

            int ans = 0;
            for(int i = 0; i < 100; i++){
                if(graph[99][i] == 2) {
                    ans = Ladder(99, i);
                    break;
                }
            }

            System.out.println("#" + T + " " + ans);
        }
    }
}
