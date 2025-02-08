import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        StringTokenizer tr = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tr.nextToken());
        }
        for(int i = n - 1; i >= 0; i--){
            stack.add(arr[i]);
        }

        int i = 1;
        while (!stack.isEmpty()){
            if(stack.peek() == i) {
                stack.pop();
                i++;
            }
            else if (!temp.isEmpty() && temp.peek() == i) {
                temp.pop();
                i++;
            } else temp.add(stack.pop());
        }

        if(!temp.isEmpty()){
            int temp_size = temp.size();
            for(int j = 0; j < temp_size; j++){
                if (!temp.isEmpty() && temp.peek() == i) {
                    temp.pop();
                    i++;
                }
            }
        }

        if(temp.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }
}