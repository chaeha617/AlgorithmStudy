import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int[] arr = new int[101];
            int ans = 0, max = 0;
            int t = Integer.parseInt(br.readLine());
            StringTokenizer tr = new StringTokenizer(br.readLine());
            for(int j = 0; j < 1000; j++){
                int num = Integer.parseInt(tr.nextToken());
                arr[num] += 1;
                if(arr[num] > max || (arr[num] == max && num > ans)){ // 최빈수가 여러 개 일 때 가장 큰 점수를 출력
                    max = arr[num];
                    ans = num;
                }
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}