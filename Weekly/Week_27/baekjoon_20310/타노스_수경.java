import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split("");
        List<String> list = new ArrayList<>(Arrays.asList(strArr));

        int zero = 0;
        int one = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0') zero++;
            else one++;
        }
        zero /= 2;
        one /= 2;

        for(int i = 0; i < str.length(); i++){
            if(list.get(i).equals("1")) {
                list.remove(i);
                one--;
            }
            if (one == 0) break;
        }

        int list_len = list.size();
        for(int i = list_len - 1; i >= 0; i--){
            if(list.get(i).equals("0")) {
                list.remove(i);
                zero--;
            }
            if (zero == 0) break;
        }

        String ans = String.join("", list);
        System.out.println(ans);
    }
}