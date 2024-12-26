import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 0; t < 10; t++){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            stack.add(str.charAt(0));

            for(int i = 1; i < n; i++){
                char c = str.charAt(i);
                if(!stack.isEmpty()) {
                    if(stack.peek() == '{' && c == '}') stack.pop();
                    else if(stack.peek() == '[' && c == ']') stack.pop();
                    else if(stack.peek() == '(' && c == ')') stack.pop();
                    else if(stack.peek() == '<' && c == '>') stack.pop();
                    else stack.add(c);
                } else stack.add(c);
            }

            System.out.print("#" + (t + 1) + " ");
            if(stack.isEmpty()) System.out.println(1);
            else System.out.println(0);

        }
    }
}