import java.io.*;
import java.util.*;

public class Main {
    static Character[][] field;
    static int h, w, n;

    public static void move(String str, int x, int y, int count) {
        if (count == n) return;

        if (str.charAt(count) == 'U') {
            count++;
            field[x][y] = '^'; // 문자 바꿔주고
            if (x - 1 >= 0 && field[x - 1][y] == '.') { // 탐색할 위치가 범위를 벗어나지 않으면서 평지('.')일 때
                field[x][y] = '.'; // 현재위치 문자를 평지로 바꾸고
                field[x - 1][y] = '^'; // 탐색위치의 문자를 전차로 바꿔주기
                move(str, x - 1, y, count); // 다음 전차에서 위치 탐색
            } else {
                move(str, x, y, count);
            }
        } else if (str.charAt(count) == 'D') {
            count++;
            field[x][y] = 'v';
            if (x + 1 < h && field[x + 1][y] == '.') {
                field[x][y] = '.';
                field[x + 1][y] = 'v';
                move(str, x + 1, y, count);
            } else {
                move(str, x, y, count);
            }
        } else if (str.charAt(count) == 'L') {
            count++;
            field[x][y] = '<';
            if (y - 1 >= 0 && field[x][y - 1] == '.') {
                field[x][y] = '.';
                field[x][y - 1] = '<';
                move(str, x, y - 1, count);
            } else {
                move(str, x, y, count);
            }
        } else if (str.charAt(count) == 'R') {
            count++;
            field[x][y] = '>';
            if (y + 1 < w && field[x][y + 1] == '.') {
                field[x][y] = '.';
                field[x][y + 1] = '>';
                move(str, x, y + 1, count);
            } else {
                move(str, x, y, count);
            }
        } else if (str.charAt(count) == 'S') {
            count++;
            if (field[x][y] == '<') { // 전차가 왼쪽으로 볼때
                for (int i = y - 1; i >= 0; i--) { // 왼쪽으로 포탑 쏘기
                    if (field[x][i] == '#') break; // 강철 벽이면 아무것도 하지않고 break;
                    else if (field[x][i] == '*') { // 벽돌 벽이면
                        field[x][i] = '.'; // 벽돌 위치의 문자를 평지로 바꿔주고 break;
                        break;
                    }
                }
            } else if (field[x][y] == '>') {
                for (int i = y + 1; i < w; i++) {
                    if (field[x][i] == '#') break;
                    else if (field[x][i] == '*') {
                        field[x][i] = '.';
                        break;
                    }
                }
            } else if (field[x][y] == '^') {
                for (int i = x - 1; i >= 0; i--) {
                    if (field[i][y] == '#') break;
                    else if (field[i][y] == '*') {
                        field[i][y] = '.';
                        break;
                    }
                }
            } else if (field[x][y] == 'v') {
                for (int i = x + 1; i < h; i++) {
                    if (field[i][y] == '#') break;
                    else if (field[i][y] == '*') {
                        field[i][y] = '.';
                        break;
                    }
                }
            }
            move(str, x, y, count); // 포탑 쏘고 다음 탐색
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer tr = new StringTokenizer(br.readLine());
            h = Integer.parseInt(tr.nextToken());
            w = Integer.parseInt(tr.nextToken());
            field = new Character[h][w];

            int x = 0, y = 0;
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    field[i][j] = str.charAt(j);
                    if (field[i][j] == '<' || field[i][j] == 'v' || field[i][j] == '^' || field[i][j] == '>') { // 전차의 위치를 x,y에 저장
                        x = i;
                        y = j;
                    }
                }
            }

            n = Integer.parseInt(br.readLine());
            String str = br.readLine(); // 입력 종류 str

            int count = 0;
            move(str, x, y, count);
            System.out.print("#" + (t + 1) + " "); // 출력
            for (int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++){
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
        }
    }
}
