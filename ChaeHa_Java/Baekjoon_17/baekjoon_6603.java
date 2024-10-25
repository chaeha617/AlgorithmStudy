// https://www.acmicpc.net/problem/6603

package Baekjoon_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class baekjoon_6603 {
    public static void main(String[] args) throws IOException {
        Lotto lotto = new Lotto();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        while(!inputLine.equals("0")){
            StringTokenizer tr = new StringTokenizer(inputLine);
            int k = Integer.parseInt(tr.nextToken());
            ArrayList<String> numbers = new ArrayList<>();
            for (int i = 0; i < k; i++){
                numbers.add(tr.nextToken());
            }
            lotto.printLottoNumbers(numbers);
            inputLine = br.readLine();
        }
        br.close();
        System.exit(0);
    }
}

class Lotto{
    List<String> lottoNumbers;

    public void printLottoNumbers(ArrayList<String> numbers){
        lottoNumbers = new ArrayList<>();
        makeLottoNumbers(numbers, numbers.size());
        lottoNumbers = lottoNumbers.stream().distinct().collect(Collectors.toList());
        for(int numberIdx = lottoNumbers.size() - 1; numberIdx >= 0; numberIdx--){
            System.out.println(lottoNumbers.get(numberIdx));
        }
        System.out.println();
    }

    public void makeLottoNumbers(ArrayList<String> numbers, int len){
        if(len <= 6){
            lottoNumbers.add(String.join(" ",numbers));
            return;
        }
        for(int idx = 0; idx < numbers.size(); idx++){
            String number = numbers.get(idx);
            numbers.remove(idx);
            makeLottoNumbers(numbers,len-1);
            numbers.add(idx, number);
        }
    }

}