import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    static int[][] LIST;
    static boolean[][] VISITED;

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
                        DFS(j, k);
                    }
                }
            }

            builder.append(bug).append("\n");
        }

        System.out.println(builder.toString());

    }

    private static void DFS(int h, int w) {
        if (VISITED[h][w]) {
            return;
        }
        VISITED[h][w] = true;

        for (int i = 0; i < 4; i++) {
            int newH = h + dy[i];
            int newW = w + dx[i];
            if(newH < 0 || newW < 0) continue;
            if(newH > LIST.length -1 || newW > LIST[0].length - 1) continue;
            if(LIST[newH][newW] == 0 || VISITED[newH][newW]) continue;

            DFS(newH, newW);
        }
    }
}
