import java.util.*;
class Solution {
    public String solution(String s) {
         String answer = "";

        String[] strings = s.split("");
        Arrays.sort(strings, Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {
            stringBuilder.append(string);
        }

        answer = stringBuilder.toString();

        return answer;
    }
}