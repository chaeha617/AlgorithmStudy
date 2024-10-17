package Baekjoon_16;

import java.util.*;

public class baekjoon_2293 {
    public static ArrayList<ArrayList<HashSet>> coinDP = new ArrayList<ArrayList<HashSet>>();

    public static int coinCount(int k, ArrayList<Integer> coinList){
        Collections.sort(coinList);

        for(int i = 0; i <= k; i++){

            for(int idx = 0; idx < coinList.size(); idx++){
                if (0 < i - coinList.get(idx)){
                    HashSet set = new HashSet<>();

                }

            }
        }

        return coinDP.get(k).size();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        scan.nextLine();

        ArrayList<Integer> coinList = new ArrayList<>();
        for(int i = 0;i < n; i++){
            coinList.add(Integer.parseInt(scan.nextLine()));
        }




        System.out.println(coinCount(k,coinList));

    }
}
