import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String a4 = "AAAA";
        String b2 = "BB";

        String ans = "";
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '.'){
                if(count % 2 == 1) {
                    System.out.println(-1);
                    return;
                }
                if(count != 0){
                    for(int j = 0; j < (count / 4); j++) ans += a4;
                    if(count % 4 != 0) ans += b2;
                    count = 0;
                }
                ans += '.';

            } else count++;

            if(i == str.length() - 1){
                if(count % 2 == 1) {
                    System.out.println(-1);
                    return;
                }

                if(count != 0) {
                    for(int j = 0; j < (count / 4); j++) ans += a4;
                    if(count % 4 != 0) ans += b2;
                }
            }
        }

        System.out.println(ans);

    }
}