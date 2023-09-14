import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Main {

    public static ArrayList<Integer>[] LIST;
    public static boolean[] VISITED;
    public static int COUNT;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        LIST = new ArrayList[node + 1];
        VISITED = new boolean[node + 1];


        for (int i = 1; i <= node; i++) {
            LIST[i] = new ArrayList<>();
        }


        for (int i = 0; i < line; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            LIST[start].add(end);
            LIST[end].add(start);
        }

        DFS(1);

        System.out.println(COUNT - 1);

    }

    private static void DFS(int startNode) {
        if (VISITED[startNode]) {
            return;
        }

        VISITED[startNode] = true;
        COUNT += 1;

        for (int node : LIST[startNode]) {
            if(!VISITED[node]) {
                DFS(node);
            }
        }
    }
}