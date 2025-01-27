import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][10];
        arr[0][0] = 0;
        for(int i=1; i<10; i++) {
            arr[0][i] = 1;
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<10; j++) {
                if(j==0) arr[i][j+1] += arr[i-1][j]%1000000000;
                else if(j==9) arr[i][j-1] += arr[i-1][j]%1000000000;
                else {
                    arr[i][j-1] += arr[i-1][j]%1000000000;
                    arr[i][j+1] += arr[i-1][j]%1000000000;
                }
            }
        }

        long answer = 0;
        for(int i=0; i<10; i++) {
            answer += arr[N-1][i];
        }
        bw.write(answer%1000000000+"");
        bw.flush();
        bw.close();
    }
}