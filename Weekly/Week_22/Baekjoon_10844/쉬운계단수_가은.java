import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        long mod = 1000000000;
        long answer = 0L;
        long[][] arr = new long[N][10];

        for(int i=1; i<10; i++) {
            arr[0][i] = 1L;
        }

        for(int i=0; i<N-1; i++) {
            arr[i+1][1] = (arr[i+1][1] + arr[i][0]) % mod;
            for(int j=1; j<9; j++) {
                arr[i+1][j-1] = (arr[i+1][j-1] + arr[i][j]) % mod;
                arr[i+1][j+1] = (arr[i+1][j+1] + arr[i][j]) % mod;
            }
            arr[i+1][8] = (arr[i+1][8] + arr[i][9]) % mod;
        }

        for(int i=0; i<10; i++) {
            answer += arr[N-1][i];
        }
        System.out.println(answer%mod);

        sc.close(); // Scanner 닫기
    }
}
