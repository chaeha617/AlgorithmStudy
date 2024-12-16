import java.util.*;
import java.io.*;

public class Main {
    static int n, m, v;
    static int[][] graph;
    static boolean[] visited;
    static String ansd = "";
    static String ansb = "";

    public static void bfs(int x) {
        visited[x] = true;
        ansb += x + " ";
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            x = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (graph[x][i] == 0) continue;
                if (visited[i]) continue;
                ansb += i + " ";
                visited[i] = true;
                q.add(i);
            }
        }
    }

    public static void dfs(int x){
        visited[x] = true;
        ansd += x + " ";
        for (int i = 1; i < n + 1; i++) {
            if (graph[x][i] == 0) continue;
            if (visited[i]) continue;
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tr.nextToken());
        m = Integer.parseInt(tr.nextToken());
        v = Integer.parseInt(tr.nextToken());
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            tr = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tr.nextToken());
            int b = Integer.parseInt(tr.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println(ansd);

        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(ansb);
    }
}