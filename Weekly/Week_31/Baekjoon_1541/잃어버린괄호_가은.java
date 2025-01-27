import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] plusNum = st.nextToken().split("-");
        System.out.println(doPlus(plusNum));

        bw.flush();
        bw.close();
    }
    static int doPlus(String[] plusNum) {
        int answer = 0;
        for(int i=0; i<plusNum.length; i++) {
            String[] intNum = plusNum[i].split("\\+");
            int a = 0;
            for(int j=0; j<intNum.length; j++) {
                a += Integer.parseInt(intNum[j]);
            }
            if(i==0) answer = a;
            else answer -= a;
        }
        return answer;
    }
}