import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int M;
    static int[] answer;
    static boolean[] visited;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        visited = new boolean[N];
        answer = new int[M];
        printSeq(0, 0);
        bw.flush();
        bw.close();
    }

    static void printSeq(int target, int level) throws IOException {
        if(target == M) {
            for(int i=0; i<M; i++) {
                bw.write(answer[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=level; i<N; i++) {
            if(!visited[i]) {
                answer[target] = arr[i];
                visited[i] = true;
                printSeq(target + 1, i);
                visited[i] = false;
            }
        }
    }
}