package Programmers;

import java.util.Arrays;

public class 붕대감기_채하 {
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15},{10, 5},{11, 5}}));
        System.out.println(sl.solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
        System.out.println(sl.solution(new int[]{5,3,2}, 30, new int[][]{{1,1}, {4,12}}));
        System.out.println(sl.solution(new int[]{1,1,1}, 20, new int[][]{{1,5}, {4,1}}));

    }
}
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int time = 0;
        for(int[] attack : attacks){
            int between = attack[0] - time -1;
            answer += bandage[1] * between;
            answer += bandage[2] * (between / bandage[0]);

            answer = Math.min(answer, health);
            answer = answer - attack[1];
            if (answer <= 0){
                answer = -1;
                break;
            }
            time = attack[0];
        }
        return answer;
    }
}
