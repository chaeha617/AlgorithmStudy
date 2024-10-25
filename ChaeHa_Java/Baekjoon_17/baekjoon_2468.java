package Baekjoon_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class baekjoon_2468 {
    static int[][] field;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        field = new int[N][N];

        ArrayList<Integer> numbers = new ArrayList();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                int number= Integer.parseInt(st.nextToken());
                field[i][j] = number;
                numbers.add(number);
            }
        }


        int maxArea = 0;
        numbers = (ArrayList<Integer>) numbers.stream().distinct().collect(Collectors.toList());
        for(int water : numbers){
            maxArea = Math.max(maxArea, countArea(water));
        }


        System.out.println(maxArea);
    }

    static int countArea(int water){
        int areaCount = 0;
        int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        int[][] visited = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j ++){
                visited[i][j] = 0;
            }
        }
        for (int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                if(field[row][col] > water) //잠겨있음
                    continue;
                if (visited[row][col] > 0) //이미 방문
                    continue;
                areaCount += 1;
                Queue queue = new LinkedList();

                queue.add(new int[]{row, col});

                while(!queue.isEmpty()){
                    int[] coordinate = (int[]) queue.remove();
                    int x = coordinate[0];
                    int y = coordinate[1];
                    for(int[] direct : direction){
                        int nx = x + direct[0];
                        int ny = y + direct[1];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                            continue;

                        visited[nx][ny] = areaCount;
                        queue.add(new int[]{nx, ny});

                    }
                }
            }
        }
        return areaCount;
    }


}
