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
            int answer = 0;

            int[] mode = new int[101];

            int num = 0;
            for (int i = 0; i < 1000; i++) {
                num = sc.nextInt();
                mode[num]++;
            }

            for(int i=0; i<101; i++) {
                answer = mode[answer] <= mode[i] ? i : answer;
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}