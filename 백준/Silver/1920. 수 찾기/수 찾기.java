import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(token.nextToken());

        int[] arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);

        token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());

        int[] arr2 = new int[M];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int num = arr2[i];
            int start = 0;
            int end = N - 1;
            boolean check = false;
            while (start <= end) {
                int index = (end + start) / 2;
                int value = arr[index];
                if (value > num) {
                    end = index - 1;
                } else if (value < num) {
                    start = index + 1;
                } else if (value == num) {
                    check = true;
                    break;
                }
            }
            if (!check) builder.append(0).append("\n");
            else builder.append(1).append("\n");
        }

        System.out.println(builder.toString());

    }
}
