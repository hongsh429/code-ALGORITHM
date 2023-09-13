import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] stringNums = br.readLine().split("");

        int[] nums = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i++) {
            nums[i] = Integer.parseInt(stringNums[i]);
        }
        int idx = 0;
        while (idx != nums.length) {

            int max = 0;
            int location = 0;
            int temp = 0;
            for (int i = idx; i < nums.length; i++) {
                if (max <= nums[i]) {
                    max = nums[i];
                    location = i;
                }
            }
            temp = nums[idx];
            nums[idx] = max;
            nums[location] = temp;
            idx++;
        }

        Arrays.stream(nums).forEach(System.out::print);
    }
}
