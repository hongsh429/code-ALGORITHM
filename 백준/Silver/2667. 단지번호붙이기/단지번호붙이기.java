import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dh = new int[]{0, 0, 1, -1};
    static int[] dw = new int[]{1, -1, 0, 0};

    static int[][] map;
    static int[][] visit;

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0 && map[i][j] == 1) {
                    BFS(i, j, ++num);
                }
            }
        }

        System.out.println(num);
        list.sort((o1, o2) -> o1 > o2 ? 1 : -1);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    private static void BFS(int h, int w, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{h, w});

        int count = 1;
        visit[h][w] = num;

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int newH = pos[0] + dh[i];
                int newW = pos[1] + dw[i];

                if (newH < 0 || newW < 0 || newH > map.length - 1 || newW > map.length - 1) continue;
                if (visit[newH][newW] != 0) continue;
                if (map[newH][newW] == 0) continue;
                count += 1;
                visit[newH][newW] = num;
                q.offer(new int[]{newH, newW});
            }
        }
        list.add(count);
    }
}
