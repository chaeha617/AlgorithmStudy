import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static LinkedList<int[][]> arr = new LinkedList<>();
    static LinkedList<Integer> playCount = new LinkedList<>();

    public static int[] solution(String[] genres, int[] plays) {
        visited = new boolean[genres.length];
        String genre;

        for(int i=0; i<genres.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                genre = genres[i];
                findArr(genres, plays, genre);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<arr.size(); i++) {
            int[][] a = arr.get(i);
            answer.add(a[0][1]);
            if(a[1][0]!=0) {
                answer.add(a[1][1]);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void findArr(String[] genres, int[] plays, String genre) {
        int[][] music = new int[2][2];
        int playMax = 0;

        for(int i=0; i<genres.length; i++) { // 모든 값을 보면서
            if(genres[i].equals(genre)) { // 현재 장르인 경우
                playMax += plays[i];
                visited[i] = true;

                if(music[0][0] < plays[i]) { // 들은 횟수가 큰 값을 찾아
                    music[1][0] = music[0][0];
                    music[1][1] = music[0][1];
                    music[0][0] = plays[i];
                    music[0][1] = i;
                }
                else if(music[1][0] < plays[i]) {
                    music[1][0] = plays[i];
                    music[1][1] = i;
                }
            }
        }
        if(playCount.isEmpty()) {
            arr.add(music);
            playCount.add(playMax);
        } else {
            for (int i = 0; i < playCount.size(); i++) {
                if (playCount.get(i) < playMax) {
                    arr.add(i, music);
                    playCount.add(i, playMax);
                    return;
                }
            }
            arr.addLast(music);
            playCount.addLast(playMax);
        }
    }
}