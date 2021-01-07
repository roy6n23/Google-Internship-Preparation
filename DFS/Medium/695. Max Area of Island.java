class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    	int max = 0;
    	for(int i = 0; i < grid.lenth; i++){
    		for(int j = 0; j < grid[0].length; j++){
    			if(grid[i][j] == 1)
    				max = Math.max(dfs(grid, i, j), max);
    		}
    	}
    }

    int dfs(int[][] grid, int i, int j){
    	if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
    		return 0;
    	}
    	//将访问过的节点设置为0，防止再次遍历
    	grid[i][j] = 0;
    	int count = 1;
    	count += dfs(grid,i-1, j);
    	count += dfs(grid,i, j-1);
    	count += dfs(grid,i+1, j);
    	count += dfs(grid,i, j+1);
    	return count;
    }
}