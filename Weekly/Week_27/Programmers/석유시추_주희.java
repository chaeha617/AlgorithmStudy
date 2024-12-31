import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    static Map<Integer, Integer> oilSizes = new HashMap<>();
    static int groupId = 2;

    public static int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    int size = bfs(i, j, land);
                    oilSizes.put(groupId++, size);
                }
            }
        }

        int maxOil = 0;
        for (int col = 0; col < m; col++) {
            maxOil = Math.max(maxOil, calculateOilForColumn(col, n, land));
        }

        return maxOil;
    }

    public static int bfs(int y, int x, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = groupId;
        int size = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (ny >= 0 && nx >= 0 && ny < land.length && nx < land[0].length) {
                    if (land[ny][nx] == 1 && visited[ny][nx] == 0) {
                        visited[ny][nx] = groupId;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return size;
    }

    public static int calculateOilForColumn(int col, int n, int[][] land) {
        Set<Integer> seenGroups = new HashSet<>();
        int totalOil = 0;

        for (int row = 0; row < n; row++) {
            int group = visited[row][col];
            if (group > 1 && !seenGroups.contains(group)) {
                totalOil += oilSizes.get(group);
                seenGroups.add(group);
            }
        }

        return totalOil;
    }

    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

        System.out.println(solution(array));
    }
}
