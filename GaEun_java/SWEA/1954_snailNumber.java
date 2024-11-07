
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();

            // 배열을 만들어 [N][N] 크기
            int[][] snail = new int[N][N];
            snail = draw(snail, 0, N, 0);

            System.out.println("#"+ test_case);

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    static int[][] draw(int[][] snail, int i, int N, int number) { // i=0;
        if (N/2.0 <= i) return snail;
        // 배열 가로 i 줄에 N개 넣어
        for(int x=i; x<N-i; x++) {
            snail[i][x] = ++number;
        }
        // 오른쪽 세로 N-i-1 N-1개 넣어
        for(int x=i+1; x<N-i; x++) {
            snail[x][N-1-i] = ++number;
        }
        // 배열 가로 N-i-1 줄에 N-1개 넣어
        for(int x=N-2-i; x>=i; x--) {
            snail[N-1-i][x] = ++number;
        }
        // 왼쪽 세로 i에 N-2개 넣어
        for(int x=N-2-i; x>=1+i; x--){
            snail[x][i] = ++number;
        }
        return draw(snail, ++i, N, number);
    }
}