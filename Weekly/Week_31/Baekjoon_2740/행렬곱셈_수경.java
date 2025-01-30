import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tr.nextToken());
        int m = Integer.parseInt(tr.nextToken());
        int[][] A = new int[n][m];
        for(int i = 0; i < n; i++) {
            tr = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                A[i][j] = Integer.parseInt(tr.nextToken());
            }
        }

        tr = new StringTokenizer(br.readLine());
        m = Integer.parseInt(tr.nextToken());
        int k = Integer.parseInt(tr.nextToken());
        int[][] B = new int[m][k];
        for(int i = 0; i < m; i++) {
            tr = new StringTokenizer(br.readLine());
            for(int j = 0; j < k; j++){
                B[i][j] = Integer.parseInt(tr.nextToken());
            }
        }

        int[][] ans = new int[n][k];
        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                for(int l = 0; l < m; l++){
                    ans[j][i] += A[j][l] * B[l][i];
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                bw.write(ans[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}