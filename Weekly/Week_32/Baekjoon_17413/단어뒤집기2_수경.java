import java.io.*;
import java.util.*;

public class Main {
    public static String input(String ans, Stack<Character> stack) {
        int stack_size = stack.size();
        for(int j = 0; j < stack_size; j++){
            ans += stack.pop();
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        String ans = "";
        int i = 0;
        while (i < str.length()){
            if(str.charAt(i) == '<'){
                ans = input(ans, stack);
                while (str.charAt(i) != '>'){
                    ans += str.charAt(i);
                    i++;
                }
                ans += str.charAt(i);
            } else if (str.charAt(i) == ' ') {
                ans = input(ans, stack);
                ans += " ";
            } else {
                stack.add(str.charAt(i));
            }
            i++;
        }
        ans = input(ans, stack);
        System.out.println(ans);

    }
}