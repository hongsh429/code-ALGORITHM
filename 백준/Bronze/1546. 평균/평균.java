import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subjectCount = Integer.parseInt(br.readLine());

        String[] subjectScores = br.readLine().split(" ");
        double maxScore = 0;
        for (int i = 0; i < subjectScores.length; i++) {
            maxScore = Math.max(Integer.parseInt(subjectScores[i]), maxScore);
        }

        double sum = 0;

        for (int i = 0; i < subjectCount; i++) {
            int score = Integer.parseInt(subjectScores[i]);
            sum += score / maxScore * 100.0;
        }
        System.out.println(sum / subjectCount);
    }
}
