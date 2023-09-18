import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] LIST = new ArrayList[100000 + 1];
    public static int[] VISITED = new int[100000 + 1];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());

        for (int i = 0; i < LIST.length; i++) {
            LIST[i] = new ArrayList<>();

            LIST[i].add(i - 1);
            LIST[i].add(i + 1);
            LIST[i].add(2 * i);
        }

        for (int i = 0; i < VISITED.length; i++) {
            VISITED[i] = -1;
        }

        BFS(start, end);

        System.out.println(VISITED[end]);
    }

    private static void BFS(int start,int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        VISITED[start] = 0;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            int count = VISITED[n];

            if(n == end) return;

            for (int a : LIST[n]) {
                if (a < 0 || a > 100000) continue;
                if (VISITED[a] != -1) continue;
                VISITED[a] = count + 1;
                queue.offer(a);
            }
        }
    }
}
