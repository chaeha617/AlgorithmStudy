package Baekjoon_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_채하 {

    static ArrayList<String> field = new ArrayList<>();
    static Integer[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    static Boolean[][] visited;
    static Integer row, col;

    static void inputValue(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            visited = new Boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    visited[i][j] = false;  // visited 배열을 false로 초기화
                }
            }
            for(int r = 0; r < row; r++){
                field.add(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        while(!queue.isEmpty()){
            int[] coor = queue.poll();
            if(coor[0] == row-1 && coor[1] == col -1)
                return coor[2];
            for(Integer[] direct : direction){
                int dx = coor[0] + direct[0];
                int dy = coor[1] + direct[1];
                if(0 > dx || dx >= row || 0 > dy || dy >= col)
                    continue;
                if ('0' == field.get(dx).charAt(dy))
                    continue;
                if(visited[dx][dy])
                    continue;
                visited[dx][dy] = true;
                queue.add(new int[] {dx, dy,coor[2] + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        inputValue();
        System.out.println(bfs());
    }
}
