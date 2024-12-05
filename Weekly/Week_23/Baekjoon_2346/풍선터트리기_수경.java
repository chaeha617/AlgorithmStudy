import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 빠르게 받기 위한 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 성능을 높이기 위한 BufferedWriter
        StringBuilder sb = new StringBuilder(); // 결과를 저장
        int N = Integer.parseInt(br.readLine()); // 첫 번째 줄에서 입력된 정수 N (원소의 개수)

        // 입력된 원소와 인덱스를 저장할 덱(Deque) 생성
        Deque<int[]> list = new ArrayDeque<>();
        StringTokenizer tr = new StringTokenizer(br.readLine()); // 두 번째 줄 입력 분리

        // 초기화: 각 원소의 위치와 값 저장
        for (int i = 0; i < N; i++) {
            int[] arr = {i + 1, Integer.parseInt(tr.nextToken())}; // (원소의 위치, 값)
            list.add(arr); // 덱에 추가
        }

        // 덱에서 순서대로 원소를 제거하며 조건에 맞게 이동
        while (list.size() > 1) {
            int[] arr = list.pollFirst(); // 맨 앞의 원소를 꺼냄
            sb.append(arr[0]).append(" "); // 해당 원소의 위치를 결과에 추가
            int n = arr[1]; // 이동할 위치 정보

            if (n > 0) {
                // 양수인 경우: 맨 앞 원소를 꺼내 덱의 뒤에 추가 (n-1번 반복)
                for (int j = 1; j < n; j++) {
                    list.offerLast(list.pollFirst());
                }
            } else if (n < 0) {
                // 음수인 경우: 맨 뒤의 원소를 꺼내 덱의 앞에 추가 (-n번 반복)
                for (int j = n; j != 0; j++) {
                    list.offerFirst(list.pollLast());
                }
            }
        }

        sb.append(list.poll()[0]); // 마지막 남은 원소의 위치 추가
        bw.write(sb + "\n"); // 결과 출력
        bw.flush(); // 출력 버퍼 비우기
    }
}