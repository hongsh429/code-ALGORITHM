import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstRow = new StringTokenizer(br.readLine());

        int numberCount = Integer.parseInt(firstRow.nextToken());
        int rowCount = Integer.parseInt(firstRow.nextToken());

        String[] stringFormatNumbers = br.readLine().split(" ");
        StringBuilder builder = new StringBuilder();

        int[] sumArray = new int[stringFormatNumbers.length];

        for (int i = 0; i < stringFormatNumbers.length; i++) {
            if (i == 0) {
                sumArray[i] = Integer.parseInt(stringFormatNumbers[i]);
            } else {

                sumArray[i] = sumArray[i - 1] + Integer.parseInt(stringFormatNumbers[i]);
            }
        }


        for (int i = 0; i < rowCount; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            int output = 0;
            int start = Integer.parseInt(row.nextToken()) - 1;
            int end = Integer.parseInt(row.nextToken()) - 1;
            if (start == 0) {
                output = sumArray[end];
            } else {
                output = sumArray[end] - sumArray[start-1];
            }

            builder.append(output).append("\n");
        }

        System.out.println(builder.toString());

    }
}