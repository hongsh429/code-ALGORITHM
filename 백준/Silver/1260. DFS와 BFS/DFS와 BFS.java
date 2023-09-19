import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] LIST;
    static boolean[] VISITED;
    static boolean[] VISITED2;

    static StringBuilder bfs = new StringBuilder();
    static StringBuilder dfs = new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int V = Integer.parseInt(token.nextToken());

        LIST = new ArrayList[N + 1];
        VISITED = new boolean[N + 1];
        VISITED2 = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            LIST[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            LIST[start].add(end);
            LIST[end].add(start);
        }
        for (int i = 1; i <= N; i++) {
            LIST[i].sort((o1, o2) -> o1 > o2 ? 1 : -1);
        }

        BFS(V);
        DFS(V);
        System.out.println(dfs.toString());
        System.out.println(bfs.toString());

    }

    private static void DFS(int node) {
        if(VISITED2[node]) return;

        VISITED2[node] = true;
        dfs.append(node).append(" ");

        for (int num : LIST[node]) {
            DFS(num);
        }
    }

    private static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        bfs.append(start).append(" ");
        VISITED[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();



            for (int num : LIST[now]) {

                if(VISITED[num]) continue;

                VISITED[num] = true;
                q.offer(num);
                bfs.append(num).append(" ");
            }
        }
    }
}
