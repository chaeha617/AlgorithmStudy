import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        tasteSel(0, 1, 0, 0);
        System.out.println(min);
    }

    static void tasteSel(int level, int s, int b, int selCount) {
        if(level==N) {
            if(selCount>0) {
                min = Math.min(min, Math.abs(s-b));
            }
            return;
        }
        tasteSel(level+1, s*arr[level][0], b+arr[level][1], selCount+1);
        tasteSel(level+1, s, b, selCount);
    }
}
