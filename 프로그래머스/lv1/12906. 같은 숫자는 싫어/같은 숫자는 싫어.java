import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        int answerLength = 0;
        int num = 0;

        // answer 배열 크기 구하기
        // 첫 인덱스가 들어오면 num에 저장,
        // 두번째부터 num 값과 비교해서 같으면 패스
        // 다르면 num에 두번째 값 저장, answerLength++
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                num = arr[i];
                answerLength++;
            }
            if (num == arr[i]) {
                continue;
            } else {
                num = arr[i];
                answerLength++;
            }
        }

        // answer[]의 길이는 answerLength
        //
        int index = 0;
        answer= new int[answerLength];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                answer[index] = arr[i];
                index++;
                continue;
            }
            if (answer[index - 1] == arr[i]) {
                continue;
            } else {
                answer[index] = arr[i];
                index++;
            }
        }

        return answer;
    }
}