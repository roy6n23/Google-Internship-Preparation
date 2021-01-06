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