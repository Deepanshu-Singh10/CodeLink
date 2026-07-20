class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n*m;
        k = k%total;

        Integer [][]ans  = new Integer[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int old = i*m+j;
                int newD = (old +k)%total;
                int row = newD/m;
                int col = newD%m;
                ans[row][col] = grid[i][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(Integer []arr:ans){
            result.add(Arrays.asList(arr));
        }
        return result;
    }
}