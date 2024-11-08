import java.io.*;
import java.util.*;

public class Solution {
    public static boolean palindrome(List<Character> list) {
        List<Character> ans_list = new LinkedList<>(list);
        Collections.reverse(ans_list);

        return list.equals(ans_list);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Character[][] arr;
        for(int t = 0; t < 10; t++){
            int T = Integer.parseInt(br.readLine());
            arr = new Character[100][100];

            for(int i = 0; i < 100; i++){
                String str = br.readLine();
                for(int j = 0; j < 100; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            int ans = 0;
            List<Character> list1, list2;
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    list1 = new LinkedList<>();
                    list2 = new LinkedList<>();
                    for(int k = j; k < 100; k++){
                        list1.add(arr[i][k]);
                        if(palindrome(list1)) ans = Math.max(ans, list1.size());
                        list2.add(arr[k][i]);
                        if(palindrome(list2)) ans = Math.max(ans, list2.size());
                    }
                }
            }
            System.out.println("#" + T + " " + ans);
        }
    }
}
