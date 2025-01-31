import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> list = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Deque<Integer> temp = new ArrayDeque<>();
        Deque<String> ansList = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            ansList.add("+");
            temp.add(i);

            while (!list.isEmpty() && !temp.isEmpty() && temp.getLast().equals(list.getFirst())){
                ansList.add("-");
                temp.removeLast();
                list.removeFirst();
            }
        }

        if (list.isEmpty()){
            int ans_size = ansList.size();
            for(int i = 0; i < ans_size; i++){
                System.out.println(ansList.getFirst());
                ansList.removeFirst();
            }
        } else System.out.println("NO");
    }
}