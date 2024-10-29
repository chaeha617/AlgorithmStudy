import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();
            int answer = 0;

            char[][] palindrome = new char[8][8];

            for (int i=0; i<8; i++) {
                String a = sc.next();
                for(int j=0; j<8; j++) {
                    palindrome[i][j] = a.charAt(j);
                }
            }

            int a=0;
            int b=0;
            for(int y=0; y<8; y++) {
                for (int i = 0; i < (8 - N + 1); i++) {
                    for (int j = 0; j < (N / 2); j++) {
                        if (palindrome[y][i+j] == palindrome[y][i + N -1 -j]) a++;
                        if (palindrome[i+j][y] == palindrome[i + N -1 -j][y]) b++;
                    }
                    if(a == N / 2) answer++; a=0;
                    if(b == N / 2) answer++; b=0;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}