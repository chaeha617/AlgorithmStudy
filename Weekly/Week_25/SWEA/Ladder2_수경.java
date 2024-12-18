import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 0; t < 10; t++){
            int T = Integer.parseInt(br.readLine());
            int[][] graph = new int[100][100];

            for(int i = 0; i < 100; i++){
                StringTokenizer tr = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    graph[i][j] = Integer.parseInt(tr.nextToken());
                }
            }

            int min = Integer.MAX_VALUE;
            int ans = 0;
            for(int i = 0; i < 100; i++){
                if(graph[99][i] == 1) {
                    int xx = 99;
                    int yy = i;
                    int count = 0;

                    while (xx > 0) {
                        if ((yy - 1) >= 0 && graph[xx][yy - 1] == 1) {
                            while ((yy - 1) >= 0 && graph[xx][yy - 1] == 1) {
                                yy--;
                                count++;
                            }
                        } else if ((yy + 1) < 100 && graph[xx][yy + 1] == 1) {
                            while ((yy + 1) < 100 && graph[xx][yy + 1] == 1) {
                                yy++;
                                count++;
                            }
                        }
                        xx--;
                        count++;
                    }

                    if(min > count) {
                        min = count;
                        ans = yy;
                    }
                }
            }

            System.out.println("#" + T + " " + ans);
        }
    }
}
