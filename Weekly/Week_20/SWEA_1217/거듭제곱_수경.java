import java.util.Scanner;

public class Main {
    static int m, count;
    public static int Square(int n){
        if(count == m) return n;
        else {
            count++;
            return n * Square(n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int T = Integer.parseInt(sc.nextLine());
            int n  = Integer.parseInt(sc.next());
            m  = Integer.parseInt(sc.next());
            sc.nextLine(); // next() 사용 후 nextLine()을 사용하려면(다음 테스트에서 T를 입력받을 때 사용할 nextLine()을 위해) nextLine()을 미리 한번 사용해야함(개행문자 제거?)

            count = 1;
            int ans = Square(n);
            System.out.println("#" + T + " " + ans);
        }
    }
}
