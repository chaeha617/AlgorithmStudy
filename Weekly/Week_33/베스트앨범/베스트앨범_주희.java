package 베스트앨범;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> album = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String line = genres[i];
            if (!album.containsKey(line)) {
                album.put(genres[i], plays[i]);
            } else {
                int value = album.get(genres[i]);
                album.put(genres[i], plays[i] + value);
            }
        }

        Map<String, List<Integer>> store = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String line = genres[i];
            if (store.containsKey(line)) {
                List<Integer> temp = store.get(line);
                temp.add(plays[i]);
                store.put(line, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(plays[i]);
                store.put(line, temp);
            }
        }
//
//        Arrays.sort(album.values().toArray(new Integer[1]));

        List<Entry<String, Integer>> sortedAlbum = new ArrayList<>(album.entrySet());
        sortedAlbum.sort((a, b) -> b.getValue().compareTo(a.getValue()));


//        for (String s : album.keySet()) {
//            System.out.println(s);
//        }

        for (List<Integer> list : store.values()) {
            Collections.sort(list, Collections.reverseOrder());
        }

        List<Integer> answer = new ArrayList<>();
        for (Entry<String, Integer> entry : sortedAlbum) {
            String s = entry.getKey();
            for (String line : store.keySet()) {
                if (s.equals(line)) {
                    List<Integer> list = store.get(line);

                    if (list.size() < 2) {
                        int v = list.get(0);
                        for (int j = 0; j < genres.length; j++) {
                            if (genres[j].equals(line) && plays[j] == v) {
                                answer.add(j);
                                break;
                            }
                        }
                    } else {
                        for (int i = 0; i < 2; i++) {
                            int v = list.get(i);
                            for (int j = 0; j < genres.length; j++) {
                                if (genres[j].equals(line) && plays[j] == v && !answer.contains(j)) {
                                    answer.add(j);
                                    break;
                                }
                            }
                        }
                    }
                }
            }


        }

//        for (int i : answer) {
//            System.out.println(i);
//        }

        return answer.stream().mapToInt(i->i).toArray();
    }

}
