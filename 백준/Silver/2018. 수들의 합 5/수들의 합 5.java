import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        int endPointer = 1;
        int startPointer = 1;
        int count = 1;
        int sum = 1;

        while (endPointer != number) {
            //최초
            if (sum < number) {
                endPointer++;
                sum += endPointer;
            } else if (sum > number) {
                sum -= startPointer;
                startPointer++;
            } else if (sum == number) {
                count++;
                endPointer++;
                sum += endPointer;
            }
        }

        System.out.println(count);
    }
}