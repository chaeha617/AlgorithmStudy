import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Deque<Integer>[] arr = new Deque[2];
        int[] answer = new int[N];

        // Deque 배열 초기화
        arr[0] = new ArrayDeque<>();
        arr[1] = new ArrayDeque<>();

        for(int i=0; i<N; i++) {
            arr[0].addLast(i+1);
            arr[1].addLast(sc.nextInt());
        }

        for(int i=0; i<N; i++) {
            answer[i] = arr[0].pollFirst();
            int index = arr[1].pollFirst();
            if(N-1 == i) continue;
            if(index > 0) {
                for(int j=1; j<index; j++) {
                    arr[0].addLast(arr[0].pollFirst());
                    arr[1].addLast(arr[1].pollFirst());
                }
            } else {
                for(int j=index; j<0; j++) {
                    arr[0].addFirst(arr[0].pollLast());
                    arr[1].addFirst(arr[1].pollLast());
                }
            }
        }

        for(int i=0; i<N-1; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.print(answer[N-1]);
    }
}
