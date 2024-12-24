package Baekjoon_4963.섬의개수_채하;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int h, w;
    static int bfs(int[][] field, boolean[][] visited){
        int answer = 0;
        int[][] direction = {{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                if(visited[i][j] || field[i][j] == 0) continue;

                answer += 1;
                visited[i][j] = true;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});

                while(!queue.isEmpty()){
                    int[] coor = queue.poll();

                    for (int [] direct: direction){
                        int x = coor[0] + direct[0];
                        int y = coor[1] + direct[1];

                        if( 0 > x || x >= h || 0 > y || y >= w) continue;

                        if(visited[x][y] || field[x][y] == 0) continue;

                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                    }
                }
            }

        }
        return answer;
    }

    static void countIsland() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            int[][] field = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++){
                    field[i][j] = Integer.parseInt(line.nextToken());
                }
            }

            System.out.println(bfs(field, visited));
        }


    }
    public static void main(String[] args) {
        try {
            countIsland();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
