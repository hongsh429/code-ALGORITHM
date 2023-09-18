import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dw = new int[]{1, 0, -1, 0};
    static int[] dh = new int[]{0, 1, 0, -1};

    static int[][] MAP;
    static boolean[][] VISITED;

    // 최고 넓이
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());

        MAP = new int[H][W];
        VISITED = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                MAP[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int maxCount = 0;
        int numberOfPicture = 0;

        for (int i = 0; i <H; i++) {
            for (int j = 0; j < W; j++) {
                if(VISITED[i][j] || MAP[i][j] == 0) continue;
                COUNT = 0;
                DFS(i, j);
                maxCount = Math.max(COUNT, maxCount);
                numberOfPicture++;
            }
        }

        System.out.println(numberOfPicture);
        System.out.println(maxCount);

    }

    private static void DFS(int h, int w) {
        // 이미 방문 했다면, return
        if (VISITED[h][w]) return;

        COUNT++;
        VISITED[h][w] = true;

        for (int i = 0; i < 4; i++) {
            int newH = h + dh[i];
            int newW = w + dw[i];

            if(newH < 0 || newW < 0 || newH > MAP.length -1 || newW > MAP[newH].length -1) continue;
            if(MAP[newH][newW] == 0 || VISITED[newH][newW]) continue;
            DFS(newH, newW);
        }
    }
}
