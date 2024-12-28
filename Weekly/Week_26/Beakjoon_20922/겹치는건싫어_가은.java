import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int Index = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Index = Math.max(Index, arr[i]);
        }
        int[] countArr = new int[Index];

        int start = 0;
        int end = 0;
        int answer = 0;
        int count = 0;
        while (end != N) {
            countArr[arr[end]-1]++;
            if(countArr[arr[end]-1] > K) {
                for(int i=start; i<end; i++) {
                    if(arr[i] == arr[end]) {
                        start = i+1;
                        end = start;
                        break;
                    }
                }
                countArr = new int[Index];
                answer = Math.max(answer, count);
                count = 0;
            } else if (countArr[arr[end]-1] <= K) {
                end++;
                count++;
            }
        }
        answer = Math.max(answer, count);

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
