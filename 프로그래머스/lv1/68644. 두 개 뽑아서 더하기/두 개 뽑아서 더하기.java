import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

//        {1 2 3 4}  1 3번
        /*
        {1 2 3 4}
         1 0 3번 = length - index + 1 = 4 - 0 -1  = 3
         2 1 2번 = 4-1-1 = 2
         3 2 1번 =
         4 3 0번
        */
         for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j <= (numbers.length - 1); j++) {
                linkedHashSet.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = linkedHashSet.stream()
                .sorted()
                .mapToInt((Integer a) -> a.intValue())
                .toArray();

        return answer;
    }
}