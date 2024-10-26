//https://www.acmicpc.net/problem/1149
//완료~!

package Baekjoon_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_1149 {

    // R, G, B 순서로 저장
    static int[][] DPList = new int[1001][3];
    static int[][] houseColorList = new int[1001][3];

    static int[][] colorMap = {{1, 2},{0, 2},{0, 1}};

    public static void calculateHouseColor(int houseCount){
        for (int count = 2; count <= houseCount; count++){
            for(int color = 0; color < 3; color++){
                int beforeNumber = Math.min(DPList[count-1][colorMap[color][0]],DPList[count-1][colorMap[color][1]]);
                DPList[count][color] = beforeNumber + houseColorList[count][color];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                houseColorList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DPList[1][0] = houseColorList[1][0];
        DPList[1][1] = houseColorList[1][1];
        DPList[1][2] = houseColorList[1][2];

        calculateHouseColor(N);

        System.out.println(Arrays.stream(DPList[N]).min().getAsInt());
    }
}
