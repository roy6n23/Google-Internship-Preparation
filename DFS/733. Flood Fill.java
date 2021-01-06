class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	return dfs(image, sr, sc, newColor, image[sr][sc]);
    }

    public int[][] dfs(int[][] image, int i, int j, int newColor, int num){
    	if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor || image[i][j] != num){
    		return;
    	}else{
    		int temp = image[i][j];
    		image[i][j] = newColor;
    		dfs(image,i+1,j,newColor,temp);
    		dfs(image,i,j+1,newColor,temp);
    		dfs(image,i-1,j,newColor,temp);
    		dfs(image,i,j-1,newColor,temp);

    	}
    	return image;
    }
}


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        DFS(image,sr,sc,newColor,oldColor);
        return image;
    }

     public void DFS(int[][] image,int x,int y,int newColor,int oldColor){
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if(image[x][y] != oldColor || image[x][y] == newColor){
            return;
        }
        image[x][y] = newColor;
        DFS(image, x - 1, y,newColor,oldColor);   
        DFS(image, x + 1, y,newColor,oldColor);   
        DFS(image, x, y - 1,newColor,oldColor);   
        DFS(image, x, y + 1,newColor,oldColor);   
    }
}