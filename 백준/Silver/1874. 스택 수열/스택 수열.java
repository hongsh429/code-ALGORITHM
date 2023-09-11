import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());
        int temp = 0;

        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(br.readLine());

            if (temp < input) {
                for (int j = temp + 1; j <= input; j++) {
                    stack.push(j);
                    sb.append("+\n");
                    temp = input;
                }

            } else if (temp >= input) {
                if(stack.peek() != input){
                    System.out.println("NO");
                    return;
                }
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
