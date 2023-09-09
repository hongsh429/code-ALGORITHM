import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static boolean[] array = new boolean[4000000 + 1];
    private static ArrayList<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        calPrimeNumber();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int i = 0;
        int j = 0;
        int count = 0;
        int sum = 2;

        while (i >= j) {


            if (sum < N) {
                if (i + 1 > list.size() - 1) break;
                i++;
                sum += list.get(i);
            } else if (sum > N) {
                sum -= list.get(j);
                if (j + 1 > list.size() - 1) break;
                j++;
            } else {
                count++;
                if (i + 1 > list.size() - 1) break;

                i++;
                sum += list.get(i);
            }
        }

        System.out.println(count);

    }

    public static void calPrimeNumber() {
        array[0] = true;
        array[1] = true;

        for (int i = 2; i < Math.sqrt(4000000); i++) {

            if (!array[i]) {

                for (int j = i * i; j <= 4000000; j += i) {
                    array[j] = true;
                }
            }
        }

        for (int i = 2; i < array.length; i++) {
            if (!array[i]) {
                list.add(i);
            }
        }
    }
}
