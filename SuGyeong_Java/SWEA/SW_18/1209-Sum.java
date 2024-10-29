import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[100][100];

        for(int t = 0; t < 10; t++){
            int T = Integer.parseInt(br.readLine());
            int max = 0; // 테스트마다 max 초기와
            for(int i = 0; i < 100; i++){ // 2차원 배열 입력 받기
                StringTokenizer tr = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    arr[i][j] = Integer.parseInt(tr.nextToken());
                }
            }

            int diagonal1 = 0, diagonal2 = 0; // 대각선 초기와
            for(int i = 0; i < 100; i++){ // 가로 중에 제일 큰 값
                int width = 0;
                for(int j = 0; j < 100; j++){
                    width += arr[i][j];
                    if(j == i) diagonal1 += arr[i][j]; // 왼쪽-오른쪽 대각선
                    if(j == (j - i)) diagonal2 += arr[i][j]; // 오른쪽 - 왼쪽 대각선
                }
                max = Math.max(width, max); // 1. 각 행 중 가장 큰 값 구하기
            }
            max = Math.max(max, Math.max(diagonal1, diagonal2)); // 2. 가장 큰 값 행과 대각선 비교

            int[] height = new int[100];
            for(int i = 0; i < 100; i++){ // 세로 중에 제일 큰 값
                for(int j = 0; j < 100; j++){
                    height[j] += arr[i][j];
                }
            }
            for(int i = 0; i < 100; i++){
                max = Math.max(max, height[i]); // 3. 위의 max 값과 각 열 중 가장 큰 값 구하기
            }
            System.out.println("#" + T + " " + max); // 4. 출력
        }
    }
}