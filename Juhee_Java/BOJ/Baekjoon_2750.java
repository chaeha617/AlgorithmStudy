package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_2750 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int A = scanner.nextInt();
            list.add(A);
        }
        scanner.close();

        list.sort(null);

        for(int i = 0; i < N; i++){
            System.out.println(list.get(i));
        }
    }
}
