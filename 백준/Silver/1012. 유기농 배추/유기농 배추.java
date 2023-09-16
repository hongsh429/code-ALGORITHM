import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 상하좌우 탐색
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static boolean[][] VISITED;
    public static int[][] LIST;

    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int bachu = Integer.parseInt(st.nextToken());
            int bug = 0;
            LIST = new int[h][w];
            VISITED = new boolean[h][w];

            for (int j = 0; j < bachu; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                LIST[y][x] = 1;
            }

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (!VISITED[j][k] && LIST[j][k] != 0) {
                        bug++;
                        BFS(j, k);
                    }
                }
            }

            builder.append(bug).append("\n");
        }

        System.out.println(builder.toString());
    }

    private static void BFS(int h, int w) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{h, w});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {

                int newH = now[0] + dy[i];
                int newW = now[1] + dx[i];

                if (newH < 0 || newW < 0) continue;
                if (newH > LIST.length - 1 || newW > LIST[0].length - 1) continue;
                if (LIST[newH][newW] == 0 || VISITED[newH][newW]) continue;
                VISITED[newH][newW] = true;
                queue.offer(new int[]{newH, newW});
            }
        }
    }
}
