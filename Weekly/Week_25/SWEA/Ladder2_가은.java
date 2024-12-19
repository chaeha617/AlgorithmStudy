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

            for(int i=0; i<100; i++) {
                for(int j=0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[] countMin = {Integer.MAX_VALUE, 0};
            for(int i=0; i<100; i++) {
                int indexX = 0;
                int indexY = 0;
                if (arr[0][i]==1) {
                    int count = 0;
                    indexY = i;

                    while (indexX != 99) {
                        if (indexY != 0 && arr[indexX][indexY - 1] == 1) { //왼쪽 확인
                            while (indexY != 0 && arr[indexX][indexY - 1] == 1) {
                                indexY--;
                                count++;
                            }
                        } else if (indexY != 99 && arr[indexX][indexY + 1] == 1) { // 오른쪽 확인
                            while (indexY != 99 && arr[indexX][indexY + 1] == 1) {
                                indexY++;
                                count++;
                            }
                        }
                        indexX++; // 아래로 이동
                        count++;
                    }
                    if(count <= countMin[0]) {
                        countMin[1] = i;
                        countMin[0] = count;
                    }
                }
            }
            System.out.println("#" + N + " " + countMin[1]);
        }
    }
}