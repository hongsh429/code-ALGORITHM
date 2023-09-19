import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int T = Integer.parseInt(br.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            list = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
            }

            token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                list[j].add(Integer.parseInt(token.nextToken()));
            }

            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    count++;
                    DFS(j);
                }
            }
            builder.append(count).append("\n");
        }

        System.out.println(builder.toString());

    }

    private static void DFS(int node) {
        if (visited[node]) return;

        visited[node] = true;

        for (int num : list[node]) {
            DFS(num);
        }
    }
}
