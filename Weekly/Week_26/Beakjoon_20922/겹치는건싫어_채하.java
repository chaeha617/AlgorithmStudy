import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 겹치는건싫어_채하 {
    public class Main{
        static int N, K;
        static Integer[] numbers;

        static void inputHandler(){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());
                st  = new StringTokenizer(br.readLine());
                numbers = new Integer[N];
                for (int i = 0; i < N; i++) {
                    numbers[i] = Integer.parseInt(st.nextToken());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        static int calculate(){
            int answer = 0;
            HashMap<Integer, Integer> numberMap = new HashMap<>();
            int start = 0;
            int idx = start;
            for (int end = 0; end < N; end++) {
                int key = numbers[end];
                numberMap.putIfAbsent(key,0);
                numberMap.replace(key, numberMap.get(key) + 1);

                // K번 초과 등장하면 start 포인터 이동
                while (numberMap.get(key) > K) {
                    numberMap.put(numbers[start], numberMap.get(numbers[start]) - 1);
                    start++;
                }

                // 구간 크기 계산
                answer = Math.max(answer, end - start + 1);
            }
            return answer;
        }

        public static void main(String[] args) {
            inputHandler();
            System.out.println(calculate());
        }
    }
}
