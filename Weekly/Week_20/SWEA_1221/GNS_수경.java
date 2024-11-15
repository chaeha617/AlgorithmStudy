import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer tr = new StringTokenizer(br.readLine());
            String testcaseNum = tr.nextToken();
            int n = Integer.parseInt(tr.nextToken());
            int[] arr = new int[n];

            tr = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                String temp = tr.nextToken();
                if(temp.equals("ZRO")) arr[i] = 0;
                if(temp.equals("ONE")) arr[i] = 1;
                if(temp.equals("TWO")) arr[i] = 2;
                if(temp.equals("THR")) arr[i] = 3;
                if(temp.equals("FOR")) arr[i] = 4;
                if(temp.equals("FIV")) arr[i] = 5;
                if(temp.equals("SIX")) arr[i] = 6;
                if(temp.equals("SVN")) arr[i] = 7;
                if(temp.equals("EGT")) arr[i] = 8;
                if(temp.equals("NIN")) arr[i] = 9;
            }
            Arrays.sort(arr);
            String[] ans_arr = new String[n];
            System.out.println(testcaseNum);
            for(int i = 0; i < n; i++){
                if(arr[i] == 0) ans_arr[i] = "ZRO";
                if(arr[i] == 1) ans_arr[i] = "ONE";
                if(arr[i] == 2) ans_arr[i] = "TWO";
                if(arr[i] == 3) ans_arr[i] = "THR";
                if(arr[i] == 4) ans_arr[i] = "FOR";
                if(arr[i] == 5) ans_arr[i] = "FIV";
                if(arr[i] == 6) ans_arr[i] = "SIX";
                if(arr[i] == 7) ans_arr[i] = "SVN";
                if(arr[i] == 8) ans_arr[i] = "EGT";
                if(arr[i] == 9) ans_arr[i] = "NIN";
                System.out.print(ans_arr[i] + " ");
            }
        }
    }
}