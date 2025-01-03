package beakjoon_20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 쿠키의신체측청_채하 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heart;
        int leftArm, rightArm, leftLeg, rightLeg;

        int waist;
        try {
            int N = Integer.parseInt(br.readLine());

            //초기화
            ArrayList<String> field = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                field.add(br.readLine());
            }
            //머리 찾기
            int index = 0;
            String row = field.get(index);
            while (row.indexOf('*') == -1) {
                row = field.get(++index);
            }
            heart = new int[]{index + 1, row.indexOf('*')};
            row = field.get(++index);
            rightArm = heart[1] - row.indexOf('*');
            leftArm = row.lastIndexOf('*') - heart[1];

            //허리 길이 구하기
            waist = 0;
            while (row.charAt(heart[1]) == '*') {
                row = field.get(++index);
                waist++;
            }

            leftLeg = 0;
            rightLeg = 0;
            //다리길이 구하기
            while (row.charAt(heart[1] - 1) == '*' || row.charAt(heart[1] + 1) == '*' && index < field.size()) {
                if (row.charAt(heart[1] - 1) == '*') {
                    rightLeg++;
                }
                if (row.charAt(heart[1] - 1) == '*') {
                    leftLeg++;
                }
                row = field.get(++index);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(heart[0] + " " + heart[1]);
        System.out.println(rightArm + " " + rightArm + " " + waist + " " + leftLeg  + " " + rightLeg);
    }



}
