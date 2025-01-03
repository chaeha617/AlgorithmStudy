package beakjoon_20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 쿠키의신체측정_채하 {

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

            leftLeg = 1;
            rightLeg = 1;
            //다리길이 구하기
            while (index < field.size() - 1 && (row.charAt(heart[1] - 1) == '*' || row.charAt(heart[1] + 1) == '*')) {
                row = field.get(++index);
                if (row.charAt(heart[1] - 1) == '*') {
                    rightLeg++;
                }
                if (row.charAt(heart[1] + 1) == '*') {
                    leftLeg++;
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println((heart[0]+1) + " " + (heart[1]+1));
        System.out.println(rightArm + " " + leftArm + " " + (waist - 1) + " " + rightLeg + " " + leftLeg);
    }



}
