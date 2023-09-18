class Solution {
    static int result = 0;
    
    public int solution(int[] numbers, int target) {
        DFS(0, numbers, target, 0);
        
        return result;
    }
    
    public void DFS(int index, int[] nums, int tg, int sum){
        if(index == nums.length){
            if(tg == sum){
                result++;
            }
            return;
        }
        
        DFS(index+1, nums, tg, sum+nums[index]);
        DFS(index+1, nums, tg, sum-nums[index]);
    }
}