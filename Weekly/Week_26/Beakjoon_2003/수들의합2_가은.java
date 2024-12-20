import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int answer = 0;
        int sum = 0;

        while (start<N && end<N) {
            sum+=arr[end];

            if(sum==target) {
                sum = 0;
                answer++;
                start++;
                end = start;
            } else if (sum<target) {
                end++;
            } else {
                sum=0;
                start++;
                end = start;
            }
        }
        bw.write(answer+"");

        bw.flush();
        bw.close();
    }
}
