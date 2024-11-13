
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        /*int T;
        T=sc.nextInt();*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();
            String remind = sc.next();
            String total = sc.next();

            String newTotal = total.replaceAll(remind, "");
            int answer = (total.length()- newTotal.length())/remind.length();

            System.out.println("#" + N + " " + answer);
        }
    }
}