package Baekjoon_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class baekjoon_15649{

public static void main(String[] args) throws IOException {
    Numbers numbers = new Numbers();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputLine = br.readLine();
    StringTokenizer tr = new StringTokenizer(inputLine);
    int n = Integer.parseInt(tr.nextToken());
    int m = Integer.parseInt(tr.nextToken());


    ArrayList<String> numberList = new ArrayList<>();
    for (int i = 1; i <= n; i++)
        numberList.add(Integer.toString(i));

    numbers.printNumberList(numberList, m);
    br.close();
    System.exit(0);
}
}

class Numbers {
    List<String> numberList;
    int numberSize;

    public void printNumberList(ArrayList<String> numbers, int m){
        numberList = new ArrayList<>();
        numberSize = m;
        makeNumbers(numbers, "", m);
        numberList = numberList.stream().distinct().collect(Collectors.toList());
        for (String s : numberList)
            System.out.println(s.trim());

    }

    public void makeNumbers(ArrayList<String> numbers, String num, int len){
        if(len < 1){
            numberList.add(num);
            return;
        }
        for(int idx = 0; idx < numbers.size(); idx++) {
            String number = numbers.remove(idx);
            makeNumbers(numbers, String.join(" ",num,number),len - 1);
            numbers.add(idx, number);
        }
    }
}
