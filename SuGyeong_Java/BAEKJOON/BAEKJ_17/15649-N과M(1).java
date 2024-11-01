import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void backtracking(List<Integer> ans, boolean[] visited) {
        if(ans.size() == m){ // 리스트 길이가 m이 되면 출력
            for(int i = 0; i < m; i++){
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int j = 1; j <= n; j++){ // 1부터 n까지
            if(visited[j]) continue;
            visited[j] = true;
            ans.add(j); // 방문하지 않았으면 리스트에 요소 추가
            backtracking(ans, visited);
            visited[j] = false;
            ans.remove(ans.size() - 1);
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tr.nextToken());
        m = Integer.parseInt(tr.nextToken());

        boolean[] visited = new boolean[n + 1]; // n + 1 길이 방문처리 리스트
        backtracking(new LinkedList<>(), visited);
    }
}