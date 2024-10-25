// https://www.acmicpc.net/problem/2447
package Baekjoon_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon_2447 {

    static String[] makeString(int star){
         String[] starString = new String[star];

         for (int i = 0; i < star; i++){
             starString[i] = " ".repeat(i);
        }

        for(int i = 2; i <= star; i = i * 3){
            for(int row = 0; row < 3; row++){
                for(int col = 0; col < 3; col++){
                    if (row == 1 && col == 1){
                        continue;
                    }


                }
            }
        }

        return starString;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        makeString(N);
    }
}
