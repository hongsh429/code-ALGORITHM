import java.io.*;
import java.util.*;

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


        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(token.nextToken());
            // 마지막 인덱스<= x < 시작 인덱스 => 갯수
            builder.append(upperBoundary(0, N, num, arr) - lowerBoundary(0, N, num, arr)).append(" ");
        }

        System.out.println(builder.toString());
    }

    private static int lowerBoundary(int start, int end, int target, int[] arr) {
        int answer = 0;
        while (start < end) {
            int midIndex = (start + end) / 2;
            int midValue = arr[midIndex];

            if (midValue >= target) {
                end = midIndex;
            } else {
                start = midIndex + 1;
            }
        }
        answer = start;
        return answer;
    }

    private static int upperBoundary(int start, int end, int target, int[] arr) {
        int answer = 0;
        while (start < end) {
            int midIndex = (start + end) / 2;
            int midValue = arr[midIndex];

            if (midValue > target) {
                end = midIndex;
            } else {
                start = midIndex + 1;
            }
        }
        answer = end;
        return answer;
    }

}
