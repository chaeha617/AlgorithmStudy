import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int fx = 0;
            int fy = 0;

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 100; j++) {
                    int num = sc.nextInt();
                    if (num == 2) {
                        fx = j;
                        fy = i;
                    }
                    temp.add(num);
                }
                graph.add(temp);
            }

            int x = fx;
            int y = fy;

            while (y > 0) {
                if (x > 0 && graph.get(y).get(x - 1) == 1) {
                    while (x > 0 && graph.get(y).get(x - 1) == 1) {
                        x--;
                    }
                }
                else if (x < 99 && graph.get(y).get(x + 1) == 1) {
                    while (x < 99 && graph.get(y).get(x + 1) == 1) {
                        x++;
                    }
                }
                y--;
            }

            System.out.println("#" + test_case + " " + x);
        }
    }
}
