
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T= 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            int answer = 0;
            Boolean[] visited = new Boolean[100];
            Arrays.fill(visited, false);
            LinkedList<Integer>[] graph = new LinkedList[100];
            for (int i = 0; i < 100; i++) {
                graph[i] = new LinkedList<>();
            }
            int testNumber = sc.nextInt();
            int wayCount = sc.nextInt();
            for (int i = 0; i < wayCount; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                graph[start].add(end);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while(!queue.isEmpty()){
                int edge = queue.poll();
                if (edge == 99){
                    answer = 1;
                    break;
                }
                if (visited[edge])
                    continue;

                visited[edge] = true;
                for (int i = 0; i < graph[edge].size(); i++) {
                    queue.add(graph[edge].get(i));
                }
            }
            System.out.println("#"+testNumber+" "+answer);
        }
    }
}