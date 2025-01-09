import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Moo게임_주희 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int length = 3;
        int k = 0;

        while (length < N) {
            k++;
            length = length * 2 + (k + 3);
        }

        System.out.println(solution(k, length, N));
    }

    public static char solution(int k, int length, int N) {
        if (k == 0) {
            return (N == 1) ? 'm' : 'o';
        }

        int prevLength = (length - (k + 3)) / 2;

        if (N <= prevLength) {
            return solution(k - 1, prevLength, N);
        } else if (N > prevLength + (k + 3)) {
            return solution(k - 1, prevLength, N - prevLength - (k + 3));
        } else {
            return (N == prevLength + 1) ? 'm' : 'o';
        }
    }
}
