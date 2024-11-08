import java.io.*;
import java.util.*;

public class Main {
    public static int getPattern(int[][] arr, int i, int y) {
        if (arr[i][y - 1] == 0 && arr[i][y - 2] == 1 && arr[i][y - 3] == 1 && arr[i][y - 4] == 0 && arr[i][y - 5] == 0 && arr[i][y - 6] == 0) {
            return 0;
        } else if (arr[i][y - 1] == 0 && arr[i][y - 2] == 0 && arr[i][y - 3] == 1 && arr[i][y - 4] == 1 && arr[i][y - 5] == 0 && arr[i][y - 6] == 0) {
            return 1;
        } else if (arr[i][y - 1] == 1 && arr[i][y - 2] == 0 && arr[i][y - 3] == 0 && arr[i][y - 4] == 1 && arr[i][y - 5] == 0 && arr[i][y - 6] == 0) {
            return 2;
        } else if (arr[i][y - 1] == 0 && arr[i][y - 2] == 1 && arr[i][y - 3] == 1 && arr[i][y - 4] == 1 && arr[i][y - 5] == 1 && arr[i][y - 6] == 0) {
            return 3;
        } else if (arr[i][y - 1] == 1 && arr[i][y - 2] == 0 && arr[i][y - 3] == 0 && arr[i][y - 4] == 0 && arr[i][y - 5] == 1 && arr[i][y - 6] == 0) {
            return 4;
        } else if (arr[i][y - 1] == 0 && arr[i][y - 2] == 0 && arr[i][y - 3] == 0 && arr[i][y - 4] == 1 && arr[i][y - 5] == 1 && arr[i][y - 6] == 0) {
            return 5;
        } else if (arr[i][y - 1] == 1 && arr[i][y - 2] == 1 && arr[i][y - 3] == 1 && arr[i][y - 4] == 0 && arr[i][y - 5] == 1 && arr[i][y - 6] == 0) {
            return 6;
        } else if (arr[i][y - 1] == 1 && arr[i][y - 2] == 0 && arr[i][y - 3] == 1 && arr[i][y - 4] == 1 && arr[i][y - 5] == 1 && arr[i][y - 6] == 0) {
            return 7;
        } else if (arr[i][y - 1] == 1 && arr[i][y - 2] == 1 && arr[i][y - 3] == 0 && arr[i][y - 4] == 1 && arr[i][y - 5] == 1 && arr[i][y - 6] == 0) {
            return 8;
        } else if (arr[i][y - 1] == 1 && arr[i][y - 2] == 0 && arr[i][y - 3] == 1 && arr[i][y - 4] == 0 && arr[i][y - 5] == 0 && arr[i][y - 6] == 0) {
            return 9;
        } else return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tr.nextToken());
            int m = Integer.parseInt(tr.nextToken());
            int[][] arr = new int[n][m];

            for(int i = 0; i < n; i++){
                String str = br.readLine();
                for(int j = 0; j < m; j++){
                    arr[i][j] = Character.getNumericValue(str.charAt(j));
                }
            }

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < n; i++){
                int y = m - 1;
                while (y >= 6) {
                    if (arr[i][y] == 1) {
                        int num = getPattern(arr, i, y);
                        if(num != -1){
                            list.add(num);
                            y -= 7;
                        } else y--;
                    } else y--;
                    if(list.size() == 8) break;
                }
                if(list.size() == 8) break;
            }

            Collections.reverse(list);
            int a = 0, b = 0;
            for(int i = 0; i < list.size(); i++){
                if((i + 1) % 2 != 0){
                    a += list.get(i);
                } else b += list.get(i);
            }

            a *= 3;
            int sum = 0;
            System.out.print("#" + (t + 1) + " ");
            if((a + b) % 10 == 0){
                for(int i = 0; i < list.size(); i++){
                    sum += list.get(i);
                }
                System.out.println(sum);
            } else System.out.println("0");
        }
    }
}