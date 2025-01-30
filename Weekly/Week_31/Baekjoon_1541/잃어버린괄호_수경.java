import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = 0;
        boolean flag = false;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '-') {
                if (flag) {
                    ans -= Integer.parseInt(temp);
                    temp = "";
                } else {
                    ans += Integer.parseInt(temp);
                    temp = "";
                    flag = true;
                }
            } else if (c == '+') {
                if (flag) {
                    ans -= Integer.parseInt(temp);
                    temp = "";
                } else {
                    ans += Integer.parseInt(temp);
                    temp = "";
                }
            } else {
                temp = temp + c;
            }
        }
        if (!temp.equals("")) {
            if (flag) {
                ans -= Integer.parseInt(temp);
            } else {
                ans += Integer.parseInt(temp);
            }
        }

        System.out.println(ans);
    }
}