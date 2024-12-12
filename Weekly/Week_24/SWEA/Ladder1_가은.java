import java.io.*;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int[][] arr = new int[100][100];
            int N = sc.nextInt();
            int indexX = 0;
            int indexY = 0;

            for(int i=0; i<100; i++) {
                for(int j=0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                    if(arr[i][j]==2) {
                        indexX = i;
                        indexY = j;
                    }
                }
            }
            while (indexX!=0) {
                if(indexY!=0 && arr[indexX][indexY-1] == 1) {
                    while (indexY!=0 && arr[indexX][indexY-1]==1) {
                        indexY--;
                    }
                } else if (indexY!=99 && arr[indexX][indexY+1] == 1) {
                    while (indexY!=99 && arr[indexX][indexY+1]==1) {
                        indexY++;
                    }
                }
                indexX--;
            }
            System.out.println("#" + N + " " + indexY);
        }
    }
}
