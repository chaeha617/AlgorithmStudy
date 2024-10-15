package Baekjoon_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class baekjoon_1253 {

    public static int findNiceNumber(int findNum, List<Integer> numlist) {

        int high = numlist.size() - 1;
        int row = 0;

        // 투포인터
        while (row < high) {
            int num = numlist.get(row) + numlist.get(high);
            if (findNum == num) {
                return 1;
            } else if (findNum < num) {
                high--;
            } else {
                row++;
            }
        }
       return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] numberList = new int[N];

        for (int i = 0; i < N; i++) {
            numberList[i] = scanner.nextInt();
        }

        // numberList를 정렬
        Arrays.sort(numberList);
        int answer = 0;

        for (int idx = 0; idx < numberList.length; idx++) {
            int findNum = numberList[idx];
            // numlist를 복사하고 현재 인덱스의 값을 제거
            List<Integer> numlist = new ArrayList<>();
            for (int num : numberList) {
                numlist.add(num);
            }
            numlist.remove(idx);
            answer += findNiceNumber(findNum, numlist);
        }

        System.out.println(answer);

        scanner.close();
    }
}
