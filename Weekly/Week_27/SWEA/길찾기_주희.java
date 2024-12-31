
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int t = sc.nextInt();
            int N = sc.nextInt();

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
            }

            int[] visited = new int[100];
            int answer = dfs(99, visited, graph, 0);
            System.out.println("#" + t + " " +answer);
        }
    }

    public static int dfs(int end, int[] visited, List<List<Integer>> graph, int current) {
        if (current == end) {
            return 1;
        }

        visited[current] = 1;

        for (int n : graph.get(current)) {
            if (visited[n] == 0) {
                if (dfs(end, visited, graph, n) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}