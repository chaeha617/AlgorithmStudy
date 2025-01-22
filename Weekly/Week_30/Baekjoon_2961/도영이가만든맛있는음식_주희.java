import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식_주희 {
    static int[] sour;
    static int[] bitter;
    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        sour = new int[N];
        bitter = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sour[i] = a;
            bitter[i] = b;
        }

        backTracking(0, 1, 0);

        System.out.println(min);
    }

    public static void backTracking(int index, int sourFlavor, int bitterFlavor) {
        if (index == N) {
            if (sourFlavor != 1 || bitterFlavor != 0) {
                min = Math.min(min, Math.abs(sourFlavor - bitterFlavor));
            }
            return;
        }

        backTracking(index + 1, sourFlavor * sour[index], bitterFlavor + bitter[index]);

        backTracking(index + 1, sourFlavor, bitterFlavor);
    }
}
