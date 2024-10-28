
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = sc.nextInt();

            int[][] num = new int[100][100];
            int[] R = new int[100];
            int[] C = new int[100];
            int[] result = new int[4];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    num[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    C[i] += num[i][j];
                    R[j] += num[i][j];
                    if(i==j) result[2] += num[i][j];
                    if(i+j == 100) result[3] += num[i][j];
                }
            }

            for(int i=0; i<100; i++) {
                result[0] = Math.max(result[0], C[i]);
                result[1] = Math.max(result[1], R[i]);
            }

            for(int i=1; i<4; i++) {
                result[0] = Math.max(result[0], result[i]);
            }

            System.out.println("#" + T + " " + result[0]);
        }
    }
}