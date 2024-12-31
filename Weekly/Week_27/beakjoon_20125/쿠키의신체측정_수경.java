import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Character[][] arr = new Character[n][n];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        int x = 0, y = 0;
        int xx = 0, yy = 0;
        int left_arm = 0, right_arm = 0, waist = 0, left_leg = 0, right_leg = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if (arr[i][j] == '*' && arr[i - 1][j] == '*' && arr[i][j - 1] == '*' && arr[i][j + 1] == '*') {
                    x = i; // 심장 위치
                    y = j;

                    xx = x + 1;
                    yy = y;
                    while (true){
                        if(arr[xx][yy] != '*') break;
                        waist++;
                        xx++;
                    }

                    xx = x;
                    yy = y - 1;
                    while (true){ // 왼팔
                        if(yy < 0 || yy >= n || arr[xx][yy] != '*') break;
                        left_arm++;
                        yy--;
                    }

                    yy = y + 1;
                    while (true) { // 오른팔
                        if (yy < 0 || yy >= n || arr[xx][yy] != '*') break;
                        right_arm++;
                        yy++;
                    }
                } else if (arr[i][j] == '_' && arr[i - 1][j] == '*' && arr[i][j - 1] == '*' && arr[i][j + 1] == '*') {
                    xx = i;
                    yy = j - 1;
                    while (true){ // 왼쪽 다리
                        if(xx < 0 || xx >= n || arr[xx][yy] != '*') break;
                        left_leg++;
                        xx++;
                    }

                    xx = i;
                    yy = j + 1;
                    while (true){ // 오른쪽 다리
                        if(xx < 0 || xx >= n || arr[xx][yy] != '*') break;
                        right_leg++;
                        xx++;
                    }
                }
            }
        }
        System.out.println((x + 1) + " " + (y + 1));
        System.out.println(left_arm + " " + right_arm + " " + waist + " " + left_leg + " " + right_leg);

    }
}