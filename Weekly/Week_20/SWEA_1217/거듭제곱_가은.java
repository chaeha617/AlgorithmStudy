import java.util.Scanner;

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
            int num = sc.nextInt();
            int result;
            int x = sc.nextInt();

            result = calculate(num, x, 0, 1);

            System.out.println("#" + N + " " + result);
        }
    }
    static int calculate(int num, int x, int i, int result) {
        if(x==i) return result;
        return calculate(num, x, i+1, result * num);
    }
}