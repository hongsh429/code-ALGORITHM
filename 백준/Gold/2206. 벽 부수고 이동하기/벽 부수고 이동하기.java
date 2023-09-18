import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dw = {1, -1, 0, 0};
    public static int[] dh = {0, 0, 1, -1};

    public static int[][] MAP;
    public static int[][][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());

        MAP = new int[H][W];
        VISITED = new int[H][W][2];

        for (int i = 0; i < H; i++) {
            String row = br.readLine();
            for (int j = 0; j < W; j++) {
                MAP[i][j] = Integer.parseInt(row.substring(j, j + 1));
            }
        }

        BFS(0, 0, 0);

        if (VISITED[H - 1][W - 1][0] == 0 && VISITED[H - 1][W - 1][1] == 0) System.out.println(-1);
        else if(VISITED[H - 1][W - 1][0] == 0){
            System.out.println(VISITED[H - 1][W - 1][1]);
        } else if (VISITED[H - 1][W - 1][1] == 0) {
            System.out.println(VISITED[H - 1][W - 1][0]);
        }else {
            System.out.println(Math.min(VISITED[H - 1][W - 1][0], VISITED[H - 1][W - 1][1]));
        }
    }

    private static void BFS(int h, int w, int crash) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{h, w, crash});

        VISITED[h][w][crash] = 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newH = pos[0] + dh[i];
                int newW = pos[1] + dw[i];
                int c = pos[2]; // 0

                if (newH < 0 || newW < 0 || newH > MAP.length - 1 || newW > MAP[newH].length - 1) continue;

                if (MAP[newH][newW] == 0 && VISITED[newH][newW][c] == 0) {
                    VISITED[newH][newW][c] = VISITED[pos[0]][pos[1]][c] + 1;
                    queue.offer(new int[]{newH, newW, c});
                }
                else if(MAP[newH][newW] == 1 && c == 0 && VISITED[newH][newW][c] == 0){
                    VISITED[newH][newW][1] = VISITED[pos[0]][pos[1]][c] + 1;
                    queue.offer(new int[]{newH, newW, 1});
                }
            }
        }
    }
}
