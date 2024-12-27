package baekjoon_19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 햄버거분배_채하 {
    public static void main(String[] args) {
        String text = "";
        int K = 0;
        int answer =0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            text = br.readLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        Deque<Character> distance = new LinkedList<>();
        int idx = 0;
        for (char hp : text.toCharArray()){
            boolean change = false;
            if(((hp == 'H') && distance.contains('P')) || ((hp == 'P') && distance.contains('H'))) {
                change = true;
            }
            while(change && !distance.isEmpty()){
                Character c = distance.poll();
                if(c != hp && c != 'N'){
                    answer++;
                    distance.addFirst('N');
                    distance.add('N');
                    break;
                }
            }
            if (!change) distance.add(hp);
            while(distance.size() > K){
                distance.poll();
            }
            idx++;
        }
        System.out.println(answer);
    }
}
