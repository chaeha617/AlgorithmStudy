import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의개수_주희 {
    static int check0 = 0;
    static int check1 = 0;
    static int check2 = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N, graph);

        System.out.println(check2);
        System.out.println(check0);
        System.out.println(check1);
    }

    public static void divide(int x, int y, int size, int[][] graph) {
        if (checkNumber(x, y, size, graph)) {
            int num = graph[x][y];
            if (num == 0) check0++;
            else if (num == 1) check1++;
            else if (num == -1) check2++;
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(x + i * newSize, y + j * newSize, newSize, graph);
            }
        }
    }

    public static boolean checkNumber(int x, int y, int size, int[][] graph) {
        int num = graph[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (graph[i][j] != num) return false;
            }
        }
        return true;
    }
}
