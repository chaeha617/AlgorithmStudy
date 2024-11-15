import java.io.*;
import java.util.*;

public class Main {
    public static boolean Omok(List<Character> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals('o')) count++;
            else count = 0;
            if (count >= 5) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Character[][] arr = new Character[n][n];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            boolean omok = false;
            for (int i = 0; i < n; i++) {
                List<Character> row = new LinkedList<>();
                List<Character> column = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    row.add(arr[i][j]);
                    column.add(arr[j][i]);
                }
                if (Omok(row) || Omok(column)) {
                    omok = true;
                    break;
                }
            }

            if (!omok) {
                for (int i = 0; i <= n - 5; i++) {
                    for (int j = 0; j <= n - 5; j++) {
                        List<Character> daegak1 = new LinkedList<>();
                        List<Character> daegak2 = new LinkedList<>();
                        for (int k = 0; k < 5; k++) {
                            daegak1.add(arr[i + k][j + k]); // 우하향 대각선
                            daegak2.add(arr[i + 4 - k][j + k]); // 우상향 대각선
                        }
                        if (Omok(daegak1) || Omok(daegak2)) {
                            omok = true;
                            break;
                        }
                    }
                    if (omok) break;
                }
            }

            // 결과 출력
            System.out.print("#" + (t + 1) + " ");
            if (omok) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
