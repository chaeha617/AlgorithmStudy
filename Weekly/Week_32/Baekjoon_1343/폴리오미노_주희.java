package Baekjoon_1343;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 폴리오미노_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        String line = st.nextToken();

        line = line.replace("XXXX", "AAAA");
        line = line.replace("XX", "BB");

        if (line.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(line);
        }

    }
}
