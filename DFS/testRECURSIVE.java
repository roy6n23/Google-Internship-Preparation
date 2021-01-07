class Solution{
	int depth = 0;
	public int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		//利用全局变量
		calDepth(root);

		return depth;
	}

	public int calDepth(TreeNode root){
		if(root == null)
			return 0;

		depth = Math.max(calDepth(root.left), calDepth(root.right)) + 1;

		return depth;
	}
}


