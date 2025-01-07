import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_주희 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long result = solution(N, M);

            System.out.println(result);
        }
    }

    public static long solution(int n, int m) {
        long result = 1;
        int k = Math.min(n, m - n);

        for (int i = 0; i < k; i++) {
            result *= (m - i);
            result /= (i + 1);
        }

        return result;
    }
}
