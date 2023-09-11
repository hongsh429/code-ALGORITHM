import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Deque<Integer> queue = new LinkedList<>();

        for (int i = N; i > 0; i--) {
            queue.addFirst(i);
        }

        while (queue.size() != 1) {
            queue.remove();
            queue.addLast(queue.poll());

        }
        System.out.println(queue.peek());
    }
}