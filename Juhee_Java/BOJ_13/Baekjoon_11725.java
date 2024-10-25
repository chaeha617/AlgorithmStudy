package BOJ_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_11725 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parents;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }


        visited = new boolean[n + 1];
        parents = new int[n + 1];

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }

    }

    static void dfs(int node){
        visited[node] = true;
        for(int i = 0; i < graph[node].size(); i++){
            if(!visited[graph[node].get(i)]){
                parents[graph[node].get(i)] = node;
                dfs(graph[node].get(i));
            }
        }
    }
}
