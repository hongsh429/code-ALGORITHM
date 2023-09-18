class Solution {
    
    static int[] ch;
    
    public int solution(int n, int[][] computers) {
        ch = new int[n];
        
        int answer = 0;
        
        for(int i=0; i < n; i++){
            if(ch[i] == 0){
                DFS(i, ch, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void DFS(int i, int[] ch, int[][] computers){
        ch[i] = 1;
        for(int j=0; j < computers.length; j++){
            if(i != j && computers[i][j] == 1 && ch[j] == 0){
                DFS(j, ch, computers);
            }
        }
    }
}