import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder a = new StringBuilder(br.readLine());
        int countZ = 0;
        int countO = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) == '0') countZ++;
            if(a.charAt(i) == '1') countO++;
        }

        for(int i=0; i<countZ/2; i++) {
            int indexZ = a.lastIndexOf("0");
            a = a.deleteCharAt(indexZ);
        }
        for(int i=0; i<countO/2; i++) {
            int indexO = a.indexOf("1");
            a = a.deleteCharAt(indexO);
        }

        bw.write(a.toString());
        bw.flush();
        bw.close();
    }
}
