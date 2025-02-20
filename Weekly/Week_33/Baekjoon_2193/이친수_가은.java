import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] result = new long[N][2];
        result[0] = new long[]{0, 1};

        for(int i=1; i<N; i++) {
            result[i][0] = result[i-1][0] + result[i-1][1];
            result[i][1] = result[i-1][0];
        }

        System.out.println(result[N-1][0] + result[N-1][1]);
    }
}