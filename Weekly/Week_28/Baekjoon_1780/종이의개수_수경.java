import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static int m_one = 0, zero = 0, one = 0;

    public static void Split(int n, int x, int y) {
        int num = graph[x][y];
        boolean bool = true;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (graph[i][j] != num) {
                    bool = false;
                    break;
                }
            }
            if (!bool) break;
        }

        if (bool) {
            if (num == -1) m_one++;
            else if (num == 0) zero++;
            else one++;
        } else {
            int size = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Split(size, x + i * size, y + j * size);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tr = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(tr.nextToken());
            }
        }

        Split(n, 0, 0);
        System.out.println(m_one);
        System.out.println(zero);
        System.out.println(one);
    }
}
