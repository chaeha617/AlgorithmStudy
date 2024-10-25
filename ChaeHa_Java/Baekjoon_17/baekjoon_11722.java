package Baekjoon_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_11722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer tr = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        int answer = 1;
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(tr.nextToken());
        }
        int[] dp = new int[N];
        for(int idx = dp.length-1; idx >= 0; idx--){
            int maxLen = 0;
            for(int i = idx + 1; i < dp.length; i++){
                if(numbers[idx] > numbers[i]){
                    maxLen = Integer.max(dp[i],maxLen);
                }
            }
            dp[idx] = maxLen + 1;
            answer = Integer.max(dp[idx],answer);
        }

        System.out.println(answer);

    }
}
