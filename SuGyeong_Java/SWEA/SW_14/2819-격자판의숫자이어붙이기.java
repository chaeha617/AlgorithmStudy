import java.io.*;
import java.util.*;
public class Main {
    static int[][] graph; // 그래프 배열
    static HashSet<String> ansList; // 격자판에서 만들어진 7자리수(문자열) 리스트들 저장(중복 제거)
    static int[] dx = {1, -1, 0, 0}; // 좌우탐색 변수
    static int[] dy = {0, 0, -1, 1}; // 상하탐색 변수
    public static void dfs(int x, int y, String numbers) { // x,y좌표, 7자리수를 만들기 위한 String 변수
        numbers = numbers + graph[x][y]; // numbers에 탐색중인 그래프 위치를 계속 저장
        if (numbers.length() == 7) { // 7자리가 되면 return
            ansList.add(numbers); // HashSet에 만들어진 7자리 수 저장 후 return
            return;
        }
        for (int l = 0; l < 4; l++) { // 상하좌우 완전 탐색 반복문
            int xx = x + dx[l];
            int yy = y + dy[l];
            if (xx < 0 || xx >= 4 || yy < 0 || yy >= 4 ) continue; // 예외처리 - 범위를 벗어날경우 continue
            dfs(xx, yy, numbers); // dfs 계속 돌려서 제일 안쪽까지 탐색
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받은 내용을 br에 전부 저장
        StringTokenizer tr; // 입력받은 한줄을 토큰?으로 묶어서 하나씩 꺼낼 수 있게
        int tt = Integer.parseInt(br.readLine()); // br에 저장해둔 내용 중 한 줄을 꺼내서 tt에 저장 - 맨 처음에 테스트케이스의 수를 먼저 입력 받으니까 테스트케이스 수가 저장됨
        for (int t = 0; t < tt; t++) { // test케이스 갯수만큼 반복
            ansList = new HashSet<>(); // 7자리수 저장 리스트(문자열로 저장)
            graph = new int[4][4]; // 그래프 배열 선언
            for (int i = 0; i < 4; i++) { // 4x4 격자판
                tr = new StringTokenizer(br.readLine()); // br에 저장해둔 내용 중 한 줄을 꺼내서 tr에 토큰으로 저장 - ex) 테스트케이스의 수 다음 줄에 입력된 1 1 1 1
                for (int j = 0; j < 4; j++) { // 4x4 격자판
                    graph[i][j] = Integer.parseInt(tr.nextToken()); // tr에 저장된 토큰을 하나씩 꺼내서 저장하여 그래프 만들어주기 - ex) 1 1 1 1 중 하나의 토큰 '1'
                }
            }
            for (int i = 0; i < 4; i++) { // 4x4 크기의 격자판에서 임의의 위치에서 시작이니까 총 16번 실행하도록
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, ""); // 각 위치에서 dfs 16번 돌리기
                }
            }
            System.out.println("#" + (t + 1) + " " + ansList.size()); // 중복은 제거된 7자리수 리스트의 총 갯수
        }
    }
}