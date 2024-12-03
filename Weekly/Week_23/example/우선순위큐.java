import java.util.*;

class Task {
    String name;
    int priority;
    int time;

    // 생성자
    public Task(String name, int priority, int time) {
        this.name = name;
        this.priority = priority;
        this.time = time;
    }

    // 우선순위 큐에서 정렬을 위한 Comparator
    public static Comparator<Task> priorityComparator = new Comparator<Task>() {
        @Override
        public int compare(Task t1, Task t2) {
            // 우선순위가 높은 것부터 처리
            if (t2.priority != t1.priority) {
                return t2.priority - t1.priority; // 우선순위 내림차순
            }
            // 우선순위가 같으면 처리 시간이 짧은 순으로
            return t1.time - t2.time; // 처리 시간 오름차순
        }
    };
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 작업 개수 입력
        System.out.print("작업 개수 입력: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // 개행문자 처리

        // 우선순위 큐 생성
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Task.priorityComparator);

        // 작업 정보 입력
        for (int i = 0; i < N; i++) {
            System.out.print("작업 정보 입력: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String name = parts[0];
            int priority = Integer.parseInt(parts[1]);
            int time = Integer.parseInt(parts[2]);

            // 작업 객체 생성 후 우선순위 큐에 추가
            taskQueue.add(new Task(name, priority, time));
        }

        // 우선순위 큐 상태 출력
        System.out.println("\n작업 처리 순서:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.printf("작업명: %s, 우선순위: %d, 처리 시간: %d\n", task.name, task.priority, task.time);
        }

        scanner.close();
    }
}
