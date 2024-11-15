import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static char[][] arr = new char[100][100];

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        /*int T;
        T=sc.nextInt();*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();

            for(int i=0; i<100; i++) {
                String a = sc.next();
                for(int j=0; j<100; j++) {
                    arr[i][j] = a.charAt(j);
                }
            }

            // 회문의 길이별로 탐색
            // 회문 길이 가장 긴 값을 구해야 함으로 100부터 0까지 탐색함
            for(int i=100; i>0; i--) {
                // 해당 회문 길이로 탐색했을 때 가로 or 세로가 회문임으로
                if(slove(i)) {
                    // 가장 긴 회문의 길이는 i
                    System.out.println("#"+N+" "+i);
                    // 가장 긴 값을 구하면 더 탐색할 필요없음
                    break;
                }
            }
        }
    }

    static boolean slove(int i) {
        // 모든 회문의 시작점을 찍어줘야됨
        for(int a=0; a<100; a++) {
            // b는 100-i까지만 -> 회문의 시작점이니까
            for(int b=0; b<=(100-i); b++) {
                // 가로 or 세로 중 하나가 회문이면 true 반환
                if(sloveRow(a,b,i) || sloveCol(a,b,i)) return true;
            }
        }
        return false;
    }

    // 가로에서 탐색
    static boolean sloveRow(int a, int b, int i) {
        // i는 탐색하려는 회문 길이
        // 회문 길이의 1/2만큼 반복 -> 회문인지를 첫점과 끝점 비교로 하니까
        for(int z=0; z<i/2; z++) {
            // 해당 문자열이 회문인지 판별
            // 회문의 시작점 b, 회문의 가장 끝점 b+i-1, 회문 안의 모든 문자를 비교할 수 있게하는 변수 z
            // 회문이 아니면 false를 반환
            if(arr[a][b+z] != arr[a][b+i-1-z]) return false;
        }
        // 회문이면 true 반환
        return true;
    }

    // 세로에서 탐색
    static boolean sloveCol(int a, int b, int i) {
        for(int z=0; z<i/2; z++) {
            if(arr[b+z][a] != arr[b+i-1-z][a]) return false;
        }
        return true;
    }
}