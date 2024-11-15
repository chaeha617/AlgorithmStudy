
import java.util.ArrayList;
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
            ArrayList<Integer> code = new ArrayList<>(N);

            for(int i=0; i<N; i++) {
                code.add(sc.nextInt());
            }

            int count = sc.nextInt();

            for(int c=0; c<count; c++) {
                String a = sc.next();
                int Index = sc.nextInt();
                int N2 = sc.nextInt();

                for(int i=0; i<N2; i++) {
                    code.add(Index+i, sc.nextInt());
                }
                for(int i=0; i<10; i++) {
                    System.out.print(code.get(i)+"\n" );
                }
                System.out.println("aaaaaaaaa");
            }

            System.out.print("#" + test_case);
            for(int i=0; i<10; i++) {
                System.out.print(" " + code.get(i));
            }
            System.out.println();
        }
    }
}