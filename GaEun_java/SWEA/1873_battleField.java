
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] user = new int[2];

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int H = sc.nextInt();
            int W = sc.nextInt();
            String[][] map = new String[H][W];

            for(int i=0; i<H; i++){
                String a = sc.next();
                for(int j=0; j<W; j++){
                    map[i][j] = String.valueOf(a.charAt(j));
                    if(map[i][j].equals("<") || map[i][j].equals(">") || map[i][j].equals("^") || map[i][j].equals("v")) {
                        user[0] = i;
                        user[1] = j;
                    }
                }
            }

            int N = sc.nextInt();
            String act = sc.next();

            for(int i=0; i<N; i++) {
                if(act.charAt(i) == 'U') map = up(map);
                else if(act.charAt(i) == 'D') map = down(map, H-1);
                else if(act.charAt(i) == 'L') map = left(map);
                else if(act.charAt(i) == 'R') map = right(map, W-1);
                else if(act.charAt(i) == 'S') map = shoot(map, map[user[0]][user[1]], H-1, W-1);
            }

            System.out.print("#"+test_case+" ");
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
    static String[][] up(String[][] map) {
        map[user[0]][user[1]] = "^";
        if(user[0]==0) return map;
        if(map[user[0]-1][user[1]].equals(".")) {
            map[user[0]][user[1]] = ".";
            map[user[0]-1][user[1]] = "^";
            user[0]--;
        }
        return map;
    }

    static String[][] down(String[][] map, int H) {
        map[user[0]][user[1]] = "v";
        if(user[0]==H) return map;
        if(map[user[0]+1][user[1]].equals(".")) {
            map[user[0]][user[1]] = ".";
            map[user[0]+1][user[1]] = "v";
            user[0]++;
        }
        return map;
    }

    static String[][] left(String[][] map) {
        map[user[0]][user[1]] = "<";
        if(user[1]==0) return map;
        if(map[user[0]][user[1]-1].equals(".")) {
            map[user[0]][user[1]] = ".";
            map[user[0]][user[1]-1] = "<";
            user[1]--;
        }
        return map;
    }

    static String[][] right(String[][] map, int W) {
        map[user[0]][user[1]] = ">";
        if(user[1]==W) return map;
        if(map[user[0]][user[1]+1].equals(".")) {
            map[user[0]][user[1]] = ".";
            map[user[0]][user[1]+1] = ">";
            user[1]++;
        }
        return map;
    }

    static String[][] shoot(String[][] map, String userShape, int H, int W) {
        if(userShape.equals("^")) {
            for(int i=user[0]-1; i>=0; i--) {
                if(map[i][user[1]].equals("#")) return map;
                if(map[i][user[1]].equals("*")) {
                    map[i][user[1]] = ".";
                    return map;
                }
            }
            return map;
        }
        if(userShape.equals("v")) {
            for(int i=user[0]+1; i<=H; i++) {
                if(map[i][user[1]].equals("#")) return map;
                if(map[i][user[1]].equals("*")) {
                    map[i][user[1]] = ".";
                    return map;
                }
            }
            return map;
        }
        if(userShape.equals("<")) {
            for(int i=user[1]-1; i>=0; i--) {
                if(map[user[0]][i].equals("#")) return map;
                if(map[user[0]][i].equals("*")) {
                    map[user[0]][i] = ".";
                    return map;
                }
            }
            return map;
        }
        if(userShape.equals(">")) {
            for(int i=user[1]+1; i<=W; i++) {
                if(map[user[0]][i].equals("#")) return map;
                if(map[user[0]][i].equals("*")) {
                    map[user[0]][i] = ".";
                    return map;
                }
            }
            return map;
        }
        return map;
    }
}