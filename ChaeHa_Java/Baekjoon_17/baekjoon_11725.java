// https://www.acmicpc.net/problem/6603

package Baekjoon_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1];
        int[] parentList = new int[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
            parentList[i] = 0;
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].edge.add(b);
            nodes[b].edge.add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int root = queue.remove();
            for (int i : nodes[root].edge){
                if(parentList[i] == 0){
                    queue.add(i);
                    parentList[i] = root;
                }
            }
        }

        for(int i = 2; i < parentList.length; i++){
            System.out.println(parentList[i]);
        }

    }

}

class Node {
    ArrayList<Integer> edge = new ArrayList<>();
}