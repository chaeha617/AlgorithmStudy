import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};

    public static boolean Move(Deque<int[]> deque, Set<String> snakeSet, int dt){
        int[] head = deque.getFirst();
        int xx = head[0] + dx[dt];
        int yy = head[1] + dy[dt];

        // 범위를 벗어나거나 몸에 부딪혔을 때
        if(xx < 0 || xx >= N || yy < 0 || yy >= N || snakeSet.contains(xx + "," + yy)) {
            return true; // 게임 종료
        }

        deque.addFirst(new int[]{xx, yy});
        snakeSet.add(xx + "," + yy);

        if(graph[xx][yy] != 1){ // 사과가 없으면 꼬리 제거
            int[] tail = deque.removeLast();
            snakeSet.remove(tail[0] + "," + tail[1]);
        } else {
            graph[xx][yy] = 0; // 사과 먹음
        }

        return false; // 계속 진행
    }

    public static int Direction(int dt, String s) {
        if(s.equals("D")) return (dt + 1) % 4; // 시계 방향 회전
        return (dt + 3) % 4; // 반시계 방향 회전
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N x N 보드
        K = Integer.parseInt(br.readLine()); // 사과의 개수
        graph = new int[N][N];

        for(int i = 0; i < K; i++){ // 보드판에 사과 표시
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tr.nextToken());
            int b = Integer.parseInt(tr.nextToken());
            graph[a - 1][b - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Queue<String[]> q = new LinkedList<>();
        for(int i = 0; i < L; i++){
            String[] commands = br.readLine().split(" ");
            q.add(commands);
        }

        int time = 0; // 현재 시간
        int direction = 0; // 방향 (0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위)
        boolean gameOver = false;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        Set<String> snakeSet = new HashSet<>();
        snakeSet.add("0,0");

        while (!q.isEmpty()) {
            String[] command = q.poll();
            int moveTime = Integer.parseInt(command[0]);
            String turn = command[1]; // 변경 방향

            while (time < moveTime){
                time++;
                gameOver = Move(deque, snakeSet, direction);
                if(gameOver) {
                    System.out.println(time);
                    return;
                }
            }
            // 방향 전환
            direction = Direction(direction, turn);
        }

        while (true) {
            time++;
            gameOver = Move(deque, snakeSet, direction);
            if(gameOver) {
                System.out.println(time);
                return;
            }
        }
    }
}
