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
//第一次有模有样的写出递归，这是参考了104题最大深度的题，注意要记住这么写啊！！！
class Solution {
    public boolean isBalanced(TreeNode root) {
    	if(root == null)
    		return true;

    	if(Math.abs(helper(root.left) - helper(root.right)) > 1){
    		return false;
    	}
    	//对每个节点进行比较，所以也要进行比较，不仅仅是根节点
    	return isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(TreeNode node){
    	if(node == null)
    		return 0;

    	int left = helper(node.left);
    	int right = helper(node.right);

    	return Math.max(left, right) + 1;
    }
}


class Solution {
    public boolean isBalanced(TreeNode root) {
    	if(root == null)
    		return true;

    	if(Math.abs(depth(root.left) - depth(root.right)) > 1)
    		return false;

    	return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root){
    	if(root == null)
    		return 0;

    	return Math.max(depth(root.left), depth(root.right))+1;
    }

    
}