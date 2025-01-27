import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 잃어버린괄호_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        String line = st.nextToken();
        List<Integer> number = new ArrayList<>();

        String[] split = line.split("-");

        for(String s : split) {
            int num = 0;
            String[] temp = s.split("\\+");
            for (String t : temp) {
                num += Integer.parseInt(t);
            }
            number.add(num);
        }

        long answer = number.get(0);
        for (int i = 1; i < number.size(); i++) {
            answer -= number.get(i);
        }
        System.out.println(answer);
    }
}
