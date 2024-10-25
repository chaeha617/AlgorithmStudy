import java.io.*;
import java.util.*;

public class Main {
    static int[] numbers;
    static int n;

    public static void backtracking(List<Integer> ans, boolean[] visited, int depth) {
        if (ans.size() == 6) { // 리스트의 길이가 6이면 6개의 숫자 출력
            for (int i = 0; i < 6; i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) { // 리스트를 사전순으로 출력해야하기 때문에 depth부터 시작
            if (visited[i]) continue; // 이미 방문했으면 continue
            visited[i] = true;
            ans.add(numbers[i]); // 방문 안했으면 방문처리 후 리스트에 원소 넣기
            backtracking(ans, visited, i + 1); // depth + 1 해주면 사전순으로 리스트가 채워짐
            visited[i] = false;
            ans.remove(ans.size() - 1);
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer tr = new StringTokenizer(br.readLine());
            n = Integer.parseInt(tr.nextToken());
            if (n == 0) break; // 0을 입력 받으면 반복문 종료
            numbers = new int[n];
            for (int i = 0; i < n; i++) { // n개의 숫자 리스트 만들어줌
                numbers[i] = Integer.parseInt(tr.nextToken());
            }
            boolean[] visited = new boolean[n]; // n개의 방문처리 리스트
            backtracking(new LinkedList<>(), visited, 0);
            System.out.println();
        }
    }

}