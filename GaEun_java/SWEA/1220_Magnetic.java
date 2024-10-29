import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int answer = 0;

            int[][] num = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    num[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<100; i++) {
                int n = 0;
                for(int j=0; j<100; j++) {
                    if(num[j][i] == 1) n++;
                    if(num[j][i] == 2 && n>=1) {
                        answer++;
                        n = 0;
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}