import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n != 0){
            if (n == 1) System.out.println(1);
            else {
                boolean[] bool = new boolean[n * 2 + 1];
                Arrays.fill(bool, true);
                for(int i = 2; i <= Math.sqrt(n * 2); i++) {
                    if (bool[i]) {
                        int j = 2;
                        while (i * j <= n * 2) {
                            bool[i * j] = false;
                            j += 1;
                        }
                    }
                }

                int count = 0;
                for(int i = n + 1; i <= n * 2; i++){
                    if(bool[i]) count++;
                }
                System.out.println(count);
            }
            n = Integer.parseInt(br.readLine());
        }
    }
}