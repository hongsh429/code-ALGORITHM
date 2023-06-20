import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> winNum = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int count = (int) Arrays.stream(lottos).filter(value -> winNum.contains(value)).count();
        int countZero = (int) Arrays.stream(lottos).filter(value -> value == 0).count();

        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        return new int[]{rank[count + countZero], rank[count]};
    }
}