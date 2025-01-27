import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int aN = Integer.parseInt(st.nextToken());
        int aM = Integer.parseInt(st.nextToken());

        int[][] A = new int[aN][aM];
        for(int i=0; i<aN; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<aM; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int bN = Integer.parseInt(st.nextToken());
        int bM = Integer.parseInt(st.nextToken());

        int[][] B = new int[bN][bM];
        for(int i=0; i<bN; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<bM; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[aN][bM];
        for(int i=0; i<aN; i++) {
            for(int j=0; j<bM; j++) {
                for(int k=0; k<bN; k++) {
                    answer[i][j] += A[i][k] * B[k][j];
                }
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        bw.flush();
        bw.close();
    }
}