import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_주희 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int start = 0, maxLength = 0;

        for (int end = 0; end < N; end++) {
            count[arr[end]]++;

            while (count[arr[end]] > K) {
                count[arr[start]]--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        System.out.println(maxLength);
    }
}
