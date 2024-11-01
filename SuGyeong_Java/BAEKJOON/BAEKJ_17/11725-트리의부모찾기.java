import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Node[] nodes;
    static int[] parent;

    public static class Node {

        public List<Integer> child = new LinkedList<>();

    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        parent[v] = 1;
        while(!q.isEmpty()) {
            v = q.poll();
            for (int i = 0; i < nodes[v].child.size(); i++) {
                int vv = nodes[v].child.get(i);
                if (parent[vv] != 0) continue;
                parent[vv] = v;
                q.add(vv);
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tr.nextToken());
            int b = Integer.parseInt(tr.nextToken());
            nodes[a].child.add(b);
            nodes[b].child.add(a);
        }
        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}