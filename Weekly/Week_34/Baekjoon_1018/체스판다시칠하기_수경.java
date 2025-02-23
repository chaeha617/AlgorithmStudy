import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static String[] graph;
    public static String std1 = "BWBWBWBW";
    public static String std2 = "WBWBWBWB";

    public static int checkGraph(int startX, int startY) {
        int ans = 0;
        for (int i = startX; i < startX + 8; i++) {
            for (int j = startY; j < startY + 8; j++) {
                if (i % 2 == 0) {
                    if (graph[i].charAt(j) != std1.charAt(j - startY)) {
                        ans++;
                    }
                } else {
                    if (graph[i].charAt(j) != std2.charAt(j - startY)) {
                        ans++;
                    }
                }
            }
        }
        return Math.min(ans, 64 - ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tr.nextToken());
        int m = Integer.parseInt(tr.nextToken());

        graph = new String[n];
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine();
        }

        int ans = 32;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                ans = Math.min(ans, checkGraph(i, j));
            }
        }

        System.out.println(ans);
    }
}