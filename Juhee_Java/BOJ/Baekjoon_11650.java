package BOJ;


import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_11650 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            list.add(new int[]{A,B});
        }

        list.sort((a,b) -> {
           if(a[0]!=b[0]){
               return Integer.compare(a[0],b[0]);
           }
           return Integer.compare(a[1],b[1]);
        });
        for(int[] pair: list){
            System.out.println(pair[0] + " "+ pair[1]);
        }
    }
}
