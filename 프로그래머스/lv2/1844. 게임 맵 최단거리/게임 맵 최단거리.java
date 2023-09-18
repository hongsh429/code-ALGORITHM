import java.util.LinkedList;
import java.util.Queue;
class Solution {
    
    static int visit[][];
    static int[] dh = new int[]{0, 0, 1, -1};
    static int[] dw = new int[]{1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        
        visit = new int[maps.length][maps[0].length];
        
        BFS(visit, maps,0 , 0);
        if(visit[maps.length - 1][maps[maps.length - 1].length - 1] == 0) return -1;
        return visit[maps.length - 1][maps[maps.length - 1].length - 1];
    }
    
    public void BFS(int[][] visit, int[][] maps,int h , int w){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{h, w});
         visit[h][w] = 1;
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            
            for(int i=0;i < 4; i++){
                int newH = pos[0] + dh[i];
                int newW = pos[1] + dw[i];
                
                if(newH < 0 || newW < 0 || newH > maps.length- 1 || newW > maps[newH].length - 1) continue;
                if(maps[newH][newW] == 0) continue;
                if(visit[newH][newW] != 0) continue;
                
                visit[newH][newW] = visit[pos[0]][pos[1]] + 1;
                queue.offer(new int[]{newH, newW});
                
               
            }
        }
    }
}