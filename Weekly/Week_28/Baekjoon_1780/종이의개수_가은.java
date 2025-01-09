import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] paper;
    static int mOne, zero, one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        paper = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countPaper(N,0, 0);
        System.out.println(mOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static void countPaper(int cut, int low, int col) {
        int[] answer = new int[3];
        int w = paper[low][col];
        outerLoop:
        for(int i=low; i<low+cut; i++) {
            for(int j=col; j<col+cut; j++) {
                if(paper[i][j]==-1) answer[0]++;
                else if (paper[i][j]==0) answer[1]++;
                else if (paper[i][j]==1) answer[2]++;

                if(paper[i][j]!=w) {
                    for(int a=0; a<3; a++) {
                        for(int b=0; b<3; b++) {
                            countPaper(cut/3, low+(a*(cut/3)), col+(b*(cut/3)));
                        }
                    }
                    break outerLoop;
                }
            }
        }
        mOne += answer[0]==(cut*cut) ? 1 : 0;
        zero += answer[1]==(cut*cut) ? 1 : 0;
        one += answer[2]==(cut*cut) ? 1 : 0;
    }
}
