import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2_채하 {
public class Main{
    static Integer[] numbers;
    static int M, N;
    static void inputHandler(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tr = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tr.nextToken());
            M = Integer.parseInt(tr.nextToken());

            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers = new Integer[N];
            for(int i = 0; i < N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Integer numbersSum(){
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            int total = numbers[i];
            if (total == M)
                answer += 1;
            for (int j = i+1; j < numbers.length; j++) {
                total += numbers[j];
                if (total == M)
                    answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        inputHandler();
        System.out.println(numbersSum());

    }
}


}
