package SWEA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            int result = numberCount(sc);
            System.out.println(String.format("#%d %d", test_case, result));
        }
    }

    public static int numberCount(Scanner sc) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        sc.nextLine();
        int max = 0;
        int max_num = 0;
        for (int i = 0; i < 1000; i++) {
            int num = sc.nextInt();
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count > max) {
                max = count;
                max_num = num;
            }
            if (count == max) {
                if (max_num < num) {
                    max_num = num;
                }
            }
        }
        return max_num;
    }
}