import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            long absO1 = Math.abs(o1);
            long absO2 = Math.abs(o2);
            if (absO1 == absO2) {
                return (o1 > o2) ? 1 : -1;
            }
            return absO1 > absO2 ? 1 : -1;
        });

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());

            if (number == 0) {
                if (priorityQueue.isEmpty()) {
                    builder.append("0").append("\n");
                } else {
                    builder.append((priorityQueue.poll())).append("\n");
                }
            } else {
                priorityQueue.add(number);
            }
        }

        System.out.println(builder.toString());
    }
}
