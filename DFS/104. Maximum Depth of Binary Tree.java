/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//===============DFS RECURSIVE===============
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int depth = 0;
        depth = Math.max(depth, maxDepth(root.left));
        depth = Math.max(depth, maxDepth(root.right));

        return depth+1;
    }
}

//=============DFS RECURSIVE==========
class Solution {
	int maxLevel = 0;

    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;

        dfs(root, 1);
        return maxLevel;
    }

    public void dfs(TreeNode root, int level){
    	if(root == null)
    		return;

    	if(level > maxLevel)
    		maxLevel = level;

    	dfs(root.left, level+1);
    	dfs(root.right, level+1);
    }
}


//=============BFS iterative============
class Solution{
	public int maxDepth(TreeNode root){
		if(root == null)
			return 0;

		int level = 0;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			level++;
			for(int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
		}

		return level;
	}
}