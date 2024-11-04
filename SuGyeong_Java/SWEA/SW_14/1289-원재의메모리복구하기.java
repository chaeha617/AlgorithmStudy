import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자에게 입력 받을 수 있는 sc
        int T = sc.nextInt(); // 기본으로 String으로 받아지기 때문에 Int형으로 받아 테스트케이스 저장
        sc.nextLine(); // 바로 아래의 nextLine을 사용할때 왜인지 바로 사용이 안되서 메서드 미리 한번 선언해주기 - next형변환이 바로 안되나..?
        for (int i = 0; i < T; i++) { // 테스트케이스 수 만큼 반복문 실행
            String str = sc.nextLine(); // 메모리값을 str에 저장
            int cnt = 0; // 수정 횟수 카운트
            if (str.charAt(0) == '1') cnt += 1; // 맨 첫 문자가 '1'이면 카운트 1
            for (int j = 1; j < str.length(); j++) { // str의 길이만큼 반복문 실행 / j=1부터
                if(str.charAt(j - 1) != str.charAt(j)) { // str의 j-1번째 문자와 str의 j번째 문자를 비교해서 서로 다르면
                    cnt++; // 카운트 + 1
                }
            }
            System.out.println("#" + (i + 1) + " " + cnt); // 카운트 된 수정 횟수 출력
        }
    }
}