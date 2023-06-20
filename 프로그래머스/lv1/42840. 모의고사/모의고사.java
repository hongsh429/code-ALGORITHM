import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
       int[] answer = {};
        int[] stuA = {1, 2, 3, 4, 5};
        int[] stuB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stuC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 맞춘 문제
        int[] stuCnt = new int[3];
        for (int i = 0; i < answers.length; i++) {

            if (answers[i] == stuA[i % 5]) {
                stuCnt[0]++;
            }
            if (answers[i] == stuB[i % 8]) {
                stuCnt[1]++;
            }
            if (answers[i] == stuC[i % 10]) {
                stuCnt[2]++;
            }
        }
        int maxScore = Arrays.stream(stuCnt).max().getAsInt();

        System.out.println("maxScore = " + maxScore);

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < stuCnt.length; i++) {
            if (stuCnt[i] == maxScore) {
                result.add(i + 1);
            }
        }
        int count = 0;
        for (Integer integer : result) {
            if (integer.intValue() == 5) {
                count++;
            }
        }

//        answer = new int[count];
//        int index = 0;
//        for (int i = 0; i < result.size(); i++) {
//            if (result.get(i) == maxScore) {
//                answer[index] = i + 1;
//                index++;
//            }
//        }
        answer = result.stream().mapToInt(a -> a).toArray();

        return answer;
    }
}