import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_12869 {
    static int[][] damage = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 1, 9},
            {3, 9, 1},
            {1, 3, 9},
            {1, 9, 3}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // SCV의 수
        int[] scv = new int[3]; // SCV 체력 배열
        boolean[][][] visited = new boolean[61][61][61];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            scv[i] = scanner.nextInt();
        }

        // N이 3보다 적으면 나머지는 0으로 채우기
        while (N < 3) {
            scv[N++] = 0;
        }

        queue.add(new int[]{scv[0], scv[1], scv[2], 0}); // {체력1, 체력2, 체력3, 공격횟수}
        visited[scv[0]][scv[1]][scv[2]] = true;

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 파이썬의 pop과 같음
            int cur0 = current[0], cur1 = current[1], cur2 = current[2];
            int attackCount = current[3];

            // 모든 SCV의 체력이 0 이하인지 확인
            if (cur0 <= 0 && cur1 <= 0 && cur2 <= 0) {
                answer = Math.min(answer, attackCount);
                continue;
            }

            for (int[] dmg : damage) {
                int next0 = Math.max(0, cur0 - dmg[0]);
                int next1 = Math.max(0, cur1 - dmg[1]);
                int next2 = Math.max(0, cur2 - dmg[2]);

                if (!visited[next0][next1][next2]) {
                    visited[next0][next1][next2] = true;
                    queue.add(new int[]{next0, next1, next2, attackCount + 1});
                }
            }
        }

        System.out.println(answer);
    }
}
