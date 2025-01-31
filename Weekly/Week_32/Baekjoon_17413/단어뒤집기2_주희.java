package Baekjoon_17413;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기2_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer1 = new StringBuffer();

        boolean foundTag = false;

        for (char ch : line.toCharArray()) {
            if (ch == '<') {
                stringBuffer.append(stringBuffer1.reverse());
                stringBuffer1.setLength(0);
                foundTag = true;
                stringBuffer.append(ch);
            } else if (ch == '>') {
                stringBuffer.append(ch);
                foundTag = false;
            } else {
                if (foundTag) {
                    stringBuffer.append(ch);
                } else {
                    if (ch == ' ') {
                        stringBuffer.append(stringBuffer1.reverse());
                        stringBuffer.append(' ');
                        stringBuffer1.setLength(0);
                    } else {
                        stringBuffer1.append(ch);
                    }
                }
            }
        }

        stringBuffer.append(stringBuffer1.reverse());
        System.out.println(stringBuffer.toString());
    }
}