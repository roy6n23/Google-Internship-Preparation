class Solution {
	//设置方向变量，方便后面进行加减
	int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int closedIsland(int[][] grid) {
    	int count = 0;
    	int row = grid.length;
    	int col = grid[0].length;
    	boolean visited = new boolean[row][col];
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			if(grid[i][j] == 0 && !visited[i][j])
    				if(dfs(grid, row, col, i, j, visited))
    					count++;
    		}
    	}
    }

    public boolean dfs(int[][] gird,int row, int col, int curRow, int curCol, boolean[][] visited){
    	if(curRow >= row || curRow < 0)
    		return false;
    	if(curCol >= col || curCol < 0)
    		return false;
    	//是海洋或者已经遍历过了
    	if(grid[curRow][curCol] == 1 || visited[curRow][curCol])
    		return true;
    	boolean flag = true;
    	for(int[] direction : dir){
    		if(!dfs(grid, row, col, curRow+direction[0], curCol+direction[1], visited))
    			flag =  false;
    	}

    	return flag;
    }
}


class Solution{
	public int closedIsland(int[][] grid){
		int count = 0;
		int row = grid.length;
    	int col = grid[0].length;
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			if(grid[i][j] = 0){
    				//先提前设置好，如果没事的话就加上1，如果有事的话就把val赋值为0，加上的也是空
    				int val = 1;
    				dfs(grid, i, j, val);
    				count += val;
    			}
    		}
    	}
	}

	public void dfs(int[][] grid, int i, int j, int val){
		//遍历到了边角，将val设置为0，之后返回
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
			val = 0;
			return;
		}

		//遍历到了海，直接return，不用管
		if(grid[i][j] != 0)
			return;
		//将这个值设置为海，防止后面再进行死循环，这么做可以是因为没有别的岛屿
		//与之相邻了，如果有的话是可以遍历到的，所以可以直接设置为0
		grid[i][j] = 1;

		dfs(grid, i+1, j, val);
		dfs(grid, i-1, j, val);
		dfs(grid, i, j+1, val);
		dfs(grid, i, j-1, val);
	}
}