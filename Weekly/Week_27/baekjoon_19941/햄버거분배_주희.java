package baekjoon_19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 햄버거분배_주희 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        String line = bufferedReader.readLine();

        Queue<Integer> hamburgers = new LinkedList<>();
        Queue<Integer> people = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (line.charAt(i) == 'H') {
                hamburgers.add(i);
            } else if (line.charAt(i) == 'P') {
                people.add(i);
            }
        }

        int answer = 0;

        while (!people.isEmpty() && !hamburgers.isEmpty()) {
            int person = people.peek();
            int hamburger = hamburgers.peek();

            if (Math.abs(person - hamburger) <= K) {
                answer++;
                people.poll();
                hamburgers.poll();
            } else if (person < hamburger) {
                people.poll();
            } else {
                hamburgers.poll();
            }
        }

        System.out.println(answer);
    }
}
