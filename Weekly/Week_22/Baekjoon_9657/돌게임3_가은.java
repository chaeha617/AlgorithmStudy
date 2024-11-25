import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 1, 1, 1));

        findNext(arr, N, 5);
        System.out.println(arr.get(N-1) == 1 ? "SK" : "CY");

        sc.close(); // Scanner 닫기
    }

    static void findNext(ArrayList<Integer> arr, int N, int index) {
        if(N > index) {
            if(arr.get(index-1)==2 || arr.get(index-3)==2 || arr.get(index-4)==2) arr.add(1);
            else arr.add(2);
            findNext(arr, N, index+1);
        }
    }
}