import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine());;
        String a;
        arr = new char[N][N];
        for(int i=0; i<N; i++) {
            a = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = a.charAt(j);
            }
        }

        Point heart = whereH();
        int[] arm = countA(heart);
        int waist = countW(heart);
        int[] leg = countL(heart, waist);

        bw.write((heart.x+1)+" "+(heart.y+1)+"\n");
        bw.write(arm[0]+" "+arm[1]+" "+waist+" "+leg[0]+" "+leg[1]);
        bw.flush();
        bw.close();
    }

    static Point whereH() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == '*') {
                    return new Point(i+1, j);
                }
            }
        }
        return new Point(0, 0);
    }

    static int[] countA(Point heart) {
        int[] count = new int[2];
        int Y = heart.y -1;
        while (Y>=0) {
            if(arr[heart.x][Y] == '*') {
                Y--;
                count[0]++;
            } else break;
        }
        Y = heart.y +1;
        while (Y<N) {
            if(arr[heart.x][Y] == '*') {
                Y++;
                count[1]++;
            } else break;
        }
        return count;
    }
    static int countW(Point heart) {
        int count = 0;
        int X = heart.x +1;
        while (X<N) {
            if(arr[X][heart.y] == '*') {
                X++;
                count++;
            } else break;
        }
        return count;
    }
    static int[] countL(Point heart, int waist) {
        int[] count = new int[2];
        int X = heart.x + waist + 1;
        while (X<N) {
            if(arr[X][heart.y-1] == '*') {
                X++;
                count[0]++;
            } else break;
        }
        X = heart.x + waist + 1;
        while (X<N) {
            if(arr[X][heart.y+1] == '*') {
                X++;
                count[1]++;
            } else break;
        }
        return count;
    }
}
