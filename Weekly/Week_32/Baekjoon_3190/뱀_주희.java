package Baekjoon_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_주희 {
    static int[][] graph;
    static int N;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        st = new StringTokenizer(bufferedReader.readLine());
        int appleCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < appleCount; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = 2;
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int moveCount = Integer.parseInt(st.nextToken());
        Map<Integer, Character> moves = new HashMap<>();

        for (int i = 0; i < moveCount; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            moves.put(time, direction);
        }

        System.out.println(simulateGame(moves));
    }

    private static int simulateGame(Map<Integer, Character> moves) {
        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{0, 0});
        graph[0][0] = 1;

        int x = 0, y = 0, dir = 0, time = 0;

        while (true) {
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || graph[ny][nx] == 1) {
                break;
            }

            snake.offer(new int[]{ny, nx});
            if (graph[ny][nx] == 2) {
                graph[ny][nx] = 1;
            } else {
                int[] tail = snake.poll();
                graph[tail[0]][tail[1]] = 0;
            }

            graph[ny][nx] = 1;
            x = nx;
            y = ny;

            if (moves.containsKey(time)) {
                char turn = moves.get(time);
                if (turn == 'D') {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
            }
        }
        return time;
    }
}
