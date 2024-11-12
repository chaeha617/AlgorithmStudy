import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t++){
            StringTokenizer tr = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tr.nextToken());
            LinkedList<Integer> list = new LinkedList<>();
            String str = tr.nextToken();
            for(int i = 0; i < n; i++){
                list.add(Character.getNumericValue(str.charAt(i)));
            }

            int left = 0, right = 1;
            while (right < list.size()){
                if(list.get(left).equals(list.get(right))) {
                    list.remove(right);
                    list.remove(left);
                    if(left > 0){
                        left--;
                        right--;
                    }
                } else {
                    left++;
                    right++;
                }
            }
            System.out.print("#" + (t + 1) + " ");
            for(int j = 0; j < list.size(); j++){
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }
}
