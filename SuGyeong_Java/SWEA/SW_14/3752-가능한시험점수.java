import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받은 내용을 br에 전부 저장
        int tt = Integer.parseInt(br.readLine()); // br에 저장해둔 내용 중 한 줄을 꺼내서 tt에 저장 - 맨 처음에 테스트케이스의 수를 먼저 입력 받으니까 테스트케이스 수가 저장됨
        for (int t = 0; t < tt; t++) { // test케이스 갯수만큼 반복
            int n = Integer.parseInt(br.readLine()); // br에 저장해둔 내용 중 한 줄을 꺼내서 n에 저장 - 테스트케이스의 수 다음 줄에 입력된 문제의 갯수
            int[] problems = new int[n]; // 각 문제 배점 저장 리스트
            StringTokenizer tr = new StringTokenizer(br.readLine()); // br에 저장해둔 내용 중 한 줄을 꺼내서 tr에 토큰으로 저장 - ex) 문제의 갯수 다음 줄에 입력된 2 3 5 (배점들)
            for (int i = 0; i < n; i++) { // 문제의 갯수만큼 반복문 실행하여 배점 리스트에 배점 저장
                problems[i] = Integer.parseInt(tr.nextToken()); // tr에 저장해둔 토큰 2 3 5 중 '2' 부터 '5'까지
            }
            int sum = 0; // 받을 수 있는 점수
            for (int num : problems) {
                sum += num; // 배점을 하나씩 sum에 더해서 최대로 맞을 수 있는 점수 저장
            }
            boolean[] visited = new boolean[sum + 1]; // 최대 점수 +1 크기의 탐색리스트 생성 - 0점 ~ 최대 점수 사이에 맞을 수 있는 점수의 bool 값을 저장
            visited[0] = true; // 0점은 true
            List<Integer> ans = new ArrayList<>(); // 맞을 수 있는 점수들을 저장하기 위한 최종리스트
            ans.add(0); // 0점은 항상 맞을 수 있으니까 최종리스트에 먼저 넣기
            for (int i = 0; i < n; i++) { // 문제 갯수만큼 반복문
                int score = problems[i]; // 배점을 score에 저장
                List<Integer> temp = new ArrayList<>(ans); // for 문에서 ans가 수정이 되기 때문에 ans의 복사본을 만들어 반복문은 돌림
                for (int ansScore : temp) {                // ans를 직접 이용해 반복문을 돌리면서 동시에 ans가 수정이 되면 오류가 생기기 때문에 복사본 이용
                    if (!visited[ansScore + score]){ // 탐색한 점수(맞을 수 있는 점수)가 아닐경우
                        visited[ansScore + score] = true; // 맞을 수 있는 점수 bool 값을 true로 바꿔주고
                        ans.add(ansScore + score); // 맞을 수 있는 점수를 ans리스트에 추가
                    }
                }
            }
            System.out.println("#" + (t + 1) + " " + ans.size()); // 맞을 수 있는 점수들이 저장된 리스트의 사이즈를 출력(맞을 수 있는 점수의 갯수)
        }
    }
}