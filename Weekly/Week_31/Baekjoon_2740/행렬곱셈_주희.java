import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱셈_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {

                int a = Integer.parseInt(st.nextToken());
                A[i][j] = a;
            }
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int M2 = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M2][K];

        for (int i = 0; i < M2; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < K; j++) {
                int a = Integer.parseInt(st.nextToken());
                B[i][j] = a;
            }
        }

        int[][] answer = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int l = 0; l < M2; l++) {
                    answer[i][j] += A[i][l] * B[l][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
