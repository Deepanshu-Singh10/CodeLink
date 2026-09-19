class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0) return -1;
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        int help [][] = new int [n][m];
        for(int i = 0;i<n;i++){
          Arrays.fill(help[i],Integer.MAX_VALUE);
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==2){
                    dfs(grid,help,i,j,0);
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1){
                    if(help[i][j]==Integer.MAX_VALUE) return -1;
                    time = Math.max(time,help[i][j]);
                }
            }
        }
        return time;
    }
    public void dfs(int [][]grid,int help[][],int i ,int j,int currentTime){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||currentTime>=help[i][j] || grid[i][j]==0) return ;
        help[i][j] = currentTime;
        dfs(grid,help,i-1,j,currentTime+1);
        dfs(grid,help,i+1,j,currentTime+1);
        dfs(grid,help,i,j-1,currentTime+1);
        dfs(grid,help,i,j+1,currentTime+1);
    }
}