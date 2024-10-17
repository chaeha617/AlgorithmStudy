
package Baekjoon_16;
/*

import java.util.*;

public class baekjoon_2293 {
    public static ArrayList<HashSet<ArrayList<Integer>>> coinDP = new ArrayList<HashSet<ArrayList<Integer>>>();

    public static int coinCount(int k, ArrayList<Integer> coinList){


        for(int i = 0; i <= k; i++){
            for(int idx = 0; idx < coinList.size(); idx++){
                int coinValue = coinList.get(idx);
                if (i - coinValue >= 0){
                    for (ArrayList<Integer> minuscoinlist : coinDP.get(i - coinList.get(idx))){
                        ArrayList<Integer> addcoinlist = (ArrayList<Integer>) minuscoinlist.clone();
                        addcoinlist.set(idx,minuscoinlist.get(idx)+1);
                        coinDP.get(i).add(addcoinlist);
                    }

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
        ArrayList<Integer> coinCountList = new ArrayList<>();

        for(int i = 0;i < n; i++){
            coinList.add(Integer.parseInt(scan.nextLine()));
            coinCountList.add(0);
        }

        for (int j = 0; j <= k; j++) {
            coinDP.add(new HashSet<ArrayList<Integer>>());
        }

        coinDP.get(0).add(coinCountList);

        System.out.println(coinCount(k,coinList));

    }
}
*/

import java.util.*;

public class baekjoon_2293 {

    public static int coinCount(int k, ArrayList<Integer> coinList){
        ArrayList<Integer> coinDP = new ArrayList<>();

        for (int j = 0; j <= k; j++) {
            coinDP.add(1);
        }

        for(int i = 0; i <= k; i++){
            for (int coinValue : coinList) {
                if (i - coinValue >= 0) {
                    coinDP.set(i, coinDP.get(i) + coinDP.get(i - coinValue));
                }
            }

        }
        return coinDP.get(k);
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


        Collections.sort(coinList);
        System.out.println(coinCount(k,coinList));

    }
}