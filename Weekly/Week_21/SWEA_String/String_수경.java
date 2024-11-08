import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t++){
            int T = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();

            int count = 0;
            for(int i = 0; i < str2.length() - str1.length() + 1; i++){
                if(str2.charAt(i) == str1.charAt(0)){
                    for(int j = 0; j < str1.length(); j++){
                        if(str2.charAt(i + j) != str1.charAt(j)) break;
                        if(j == str1.length() - 1) count++;
                    }
                }
            }
            System.out.println("#" + T + " " + count);
        }
    }
}