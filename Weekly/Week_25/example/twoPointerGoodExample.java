import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 변수 초기화
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        // arr의 위치를 나타내는 두 포인터 start, end 선언
        int start = 0;
        int end = N-1;
        int sum = 0;
        int answer = 0;

        Arrays.sort(arr);

        while (start < end) {
            sum = arr[start] + arr[end];
            if(sum==target) {
                answer++;
                start++;
                end--;
            }
            else if(sum<target) start++;
            else end--;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}