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
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken()); // 행
        M = Integer.parseInt(token.nextToken()); // 열

        LIST = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            String line = token.nextToken();
            for (int j = 0; j < M; j++) {
                LIST[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        BFS(0, 0);

        System.out.println(LIST[N - 1][M - 1]);
    }

    // y축, x축
    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int plus = 0;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            VISITED[now[0]][now[1]] = true;
            plus = Math.max(LIST[now[0]][now[1]], plus);
            for (int k = 0; k < 4; k++) {
                int y = now[0] + dy[k];
                int x = now[1] + dx[k];
                if (y < 0 || x < 0) continue;
                if (x > M - 1 || y > N - 1) continue;

                if (LIST[y][x] == 1 && !VISITED[y][x]) {
                    queue.offer(new int[]{y, x});
                    LIST[y][x] += plus;
                }
            }
        }
    }
}
