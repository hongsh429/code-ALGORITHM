import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberCount = Integer.parseInt(br.readLine());
        int sumNumber = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] numberArray = new int[numberCount];

        for (int i = 0; i < numberCount; i++) {
            numberArray[i] = Integer.parseInt(token.nextToken());
        }

        // 정렬 n * log(n)
        Arrays.sort(numberArray);

        int count = 0;
        int start = 0;
        int end = numberArray.length - 1;

        while (end > start) {
            if (numberArray[start] + numberArray[end] == sumNumber) {
                count++;
                start++;
                end--;
            } else if (numberArray[start] + numberArray[end] > sumNumber) {
                end--;
            }else{
                start++;
            }
        }

        System.out.println(count);


    }
}