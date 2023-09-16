import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dw = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 1, -1, 0, 0};
    static int[] dd = {0, 0, 0, 0, 1, -1};

    static int[][][] BOX;
    static boolean[][][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(token.nextToken());
        int h = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());

        BOX = new int[d][h][w];
        VISITED = new boolean[d][h][w];

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < h; j++) {
                token = new StringTokenizer(br.readLine());
                for (int k = 0; k < w; k++) {
                    BOX[i][j][k] = Integer.parseInt(token.nextToken());
                }
            }
        }

        // 0 이 하나도 없다면,  0 출력 -> 종료
        boolean check = false;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (BOX[i][j][k] == 0) check = true;
                }
            }
        }
        if (!check) {
            System.out.println(0);
            return;
        }

        // 날짜 채워 넣기
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (!VISITED[i][j][k] && BOX[i][j][k] == 1) {
                        BFS(i, j, k);
                    }
                }
            }
        }

        int days = 0;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    int boxNumber = BOX[i][j][k];

                    if (boxNumber == 0) {
                        System.out.println(-1);
                        return;
                    }
                    days = Math.max(days, boxNumber);
                }
            }
        }
        System.out.println(days - 1);

    }

    private static void BFS(int dep, int hei, int wid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{dep, hei, wid});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowDay = BOX[now[0]][now[1]][now[2]];
            for (int i = 0; i < 6; i++) {
                int newDep = now[0] + dd[i];
                int newHei = now[1] + dh[i];
                int newWid = now[2] + dw[i];

                if (newDep < 0 || newHei < 0 || newWid < 0) continue;
                if (newDep > BOX.length - 1 ||
                        newHei > BOX[newDep].length - 1 ||
                        newWid > BOX[newDep][newHei].length - 1) continue;
//                if(VISITED[newDep][newHei][newWid] || BOX[newDep][newHei][newWid] != 0) continue;

                if(!VISITED[newDep][newHei][newWid] && BOX[newDep][newHei][newWid] == 0){
                    VISITED[newDep][newHei][newWid] = true;
                    BOX[newDep][newHei][newWid] = nowDay + 1;
                    queue.offer(new int[]{newDep, newHei, newWid});
                } else if (VISITED[newDep][newHei][newWid] && BOX[newDep][newHei][newWid] > nowDay + 1) {
                    BOX[newDep][newHei][newWid] = nowDay + 1;
                    queue.offer(new int[]{newDep, newHei, newWid});
                }
//
//                VISITED[newDep][newHei][newWid] = true;
//                BOX[newDep][newHei][newWid] = nowDay + 1;
//                queue.offer(new int[]{newDep, newHei, newWid});


            }
        }
    }
}
