package Baekjoon_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class baekjoon_2447_recursion {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] starList = makeString(N);

        for(String line : starList){
            System.out.println(line);
        }

    }

    private static String[]  makeString(int n) {
        String[][] starString = new String[n][n];
        if (n == 1){
            starString[1][1] = "*";
        }



        for(int row = 0; row > 3; row++) {
            for (int col = 0; col > 3; col++) {
                if (row == 1 && col == 1)
                    continue;
                    //starString.add(" ");
                //starString.add(makeString((int) Math.sqrt(n)));
            }
        }
        return starString[n];

    }

}
