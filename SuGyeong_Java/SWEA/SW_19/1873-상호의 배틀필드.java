import java.io.*;
import java.util.*;

public class Main {
    static Character[][] field;
    static int h, w, n;

    public static void move(String str, int x, int y, int count) {
        if (count == n) return;

        if (str.charAt(count) == 'U') {
            count++;
            field[x][y] = '^';
            if (x - 1 >= 0 && field[x - 1][y] == '.') {
                field[x][y] = '.';
                field[x - 1][y] = '^';
                move(str, x - 1, y, count);
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
            if (field[x][y] == '<') {
                for (int i = y - 1; i >= 0; i--) {
                    if (field[x][i] == '#') break;
                    else if (field[x][i] == '*') {
                        field[x][i] = '.';
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
            move(str, x, y, count);
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
                    if (field[i][j] == '<' || field[i][j] == 'v' || field[i][j] == '^' || field[i][j] == '>') {
                        x = i;
                        y = j;
                    }
                }
            }

            n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            int count = 0;
            move(str, x, y, count);
            System.out.print("#" + (t + 1) + " ");
            for (int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++){
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
        }
    }
}
