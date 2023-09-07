import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader number = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(number.readLine());
        String[] numbers = number.readLine().split("");

        long sum = 0;
        for (int i = 0; i < numCount; i++) {
            sum += Long.parseLong(numbers[i]);
        }

        System.out.println(sum);
    }
}