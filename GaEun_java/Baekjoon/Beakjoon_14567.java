package Beakjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sub = new Scanner(System.in);
    static int x = sub.nextInt();
    static int y = sub.nextInt();
    static List<Integer>[] presubject = new ArrayList[x];

    public static void main(String[] args) {
        for(int i=0; i<x; i++) {
            presubject[i] = new ArrayList<>();
        }

        for(int i=0; i<y; i++) {
            int subj = sub.nextInt();
            int ject = sub.nextInt();
            presubject[ject-1].add(subj-1);
        }

        int[] answer = new int[x];
        String end = "";

        for(int i=0; i<x; i++) {
            answer[i] = find(i, answer);
            end += answer[i] + " ";
        }
        end = end.substring(0, end.length() - 1);
        System.out.println(end);
    }

    public static int find(int subject, int[] answer) {
        if (answer[subject] != 0 ) return answer[subject];

        int maxN = 1;
        for(int pre : presubject[subject]) {
            maxN = Math.max(maxN, 1+find(pre, answer));
        }
        return maxN;
    }
}