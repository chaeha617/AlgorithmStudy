import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPalindrome(String word){
        int n = word.length();
        for (int i = 0; i < n; i++) { // 양 끝 두 자리씩 비교
            if (word.charAt(i) != word.charAt(n - i - 1)) {
                return false; // 양 끝 두 자리가 같지 않으면 false
            }
        }
        return true; // 양 끝 두 자리가 같으면 true
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] charArr = new char[8][8];

        for(int t = 0; t < 10; t++){
            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < 8; i++){ // 배열 입력받기
                String str = br.readLine();
                for(int j = 0; j < 8; j++){
                    charArr[i][j] = str.charAt(j);
                }
            }

            int ans = 0;
            for(int i = 0; i < 8; i++){ // 각 행마다 길이가 n인 str를 전부 isPalindrome()에 넣어서 회문인지 판별
                for(int j = 0; j <= 8 - n; j++){
                    String str = "";
                    for(int k = 0; k < n; k++) {
                        str += charArr[i][j + k];
                    }
                    if (isPalindrome(str)) ans += 1; // isPalindrome()에서 true가 리턴되면 ans + 1
                }
            }

            for(int i = 0; i <= 8 - n; i++){ // 각 열마다 길이가 n인 str를 전부 isPalindrome()에 넣어서 회문인지 판별
                for(int j = 0; j < 8; j++){
                    String str = "";
                    for(int k = 0; k < n; k++) {
                        str += charArr[i + k][j];
                    }
                    if (isPalindrome(str)) ans += 1; // isPalindrome()에서 true가 리턴되면 ans + 1
                }
            }
            System.out.println("#" + (t + 1) + " " + ans);
        }
    }
}