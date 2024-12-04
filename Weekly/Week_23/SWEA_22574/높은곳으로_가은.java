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
            int P = sc.nextInt();
            int[] chooseCase = new int[N+1];

            for(int j=0; j<N; j++) {
                for(int i=1; i<N+1; i++) {
                    if(j==i) continue;
                    if(chooseCase[j]+i != P) {
                        chooseCase[j] += i;
                    }
                    else {
                        chooseCase[j] = 0;
                        break;
                    }
                }
            }

            int answer = 0;
            for(int i=0; i<N; i++) {
                answer = Math.max(answer, chooseCase[i]);
            }
            System.out.println(answer);
        }
    }
}