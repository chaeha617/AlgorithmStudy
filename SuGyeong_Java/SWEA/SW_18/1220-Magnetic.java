import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++){ // 배열 입력 받기
                StringTokenizer tr = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(tr.nextToken());
                }
            }

            int ans = 0;
            for(int i = 0; i < n; i++){
                List<Integer> list = new LinkedList<>();
                for(int j = 0; j < n; j++){ // 아래로 내려가면서 0이 아닌 숫자가 나오면 list에 추가
                    if(arr[j][i] != 0) {
                        list.add(arr[j][i]);
                    }
                }
                for(int j = 0; j < list.size() - 1; j++){
                    if(list.get(j) == 1 && list.get(j + 1) == 2) ans += 1; // 탐색하는 위치의 숫자가 1일 때 다음 숫자가 2면 ans + 1
                }
            }
            System.out.println("#" + (t + 1) + " " + ans);

        }
    }
}