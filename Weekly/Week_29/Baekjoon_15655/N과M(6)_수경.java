import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, m;
    public static void back(List<Integer> ans, boolean[] visited, int depth){
        if(ans.size() == m){
            for(int i = 0 ; i < m; i++){
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
        for(int i = depth; i < arr.length; i++){
            if(visited[arr[i]]) continue;
            visited[arr[i]] = true;
            ans.add(arr[i]);
            back(ans, visited, i + 1);
            ans.remove(ans.size() - 1);
            visited[arr[i]] = false;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tr.nextToken());
        m = Integer.parseInt(tr.nextToken());
        arr = new int[n];
        tr = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tr.nextToken());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);
        boolean[] visited = new boolean[max + 1];
        back(new LinkedList<>(), visited, 0);
    }
}