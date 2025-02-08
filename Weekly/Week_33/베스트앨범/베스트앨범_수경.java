import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Set<String> hashSet = new HashSet<>(Arrays.asList(genres));

        Map<String, Integer> genresMap = new HashMap<>();
        for (String genre : hashSet) {
            int sum = 0;
            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j])) sum += plays[j];
            }
            genresMap.put(genre, sum);
        }

        List<String> listKeySet = new ArrayList<>(genresMap.keySet());
        listKeySet.sort((a, b) -> genresMap.get(b).compareTo(genresMap.get(a)));

        List<Integer> answerList = new ArrayList<>();

        for (String genre : listKeySet) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j])) {
                    map.put(j, plays[j]);
                }
            }

            List<Integer> tempSet = new ArrayList<>(map.keySet());
            tempSet.sort((a, b) -> map.get(b).compareTo(map.get(a)));

            for (int j = 0; j < Math.min(2, tempSet.size()); j++) {
                answerList.add(tempSet.get(j));
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}