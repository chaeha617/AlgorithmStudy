// 기사단원의 무기
package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int l = Integer.parseInt(bf.readLine());
        int p = Integer.parseInt(bf.readLine());

        Solution solution = new Solution();
        int result = solution.solution(n,l,p);
        System.out.println(result);
    }

    public int solution ( int number, int limit, int power){
        int answer = 0;

        for (int i = 1; i < number + 1; i++) {
            int count = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    count += 1;
                    if (j != i / j) {
                        count++;
                    }
                }
            }
            if(count <= limit) {
                answer += count;
            } else {
                answer += power;
            }

        }

        return answer;
    }
}
