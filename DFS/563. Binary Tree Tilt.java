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
class Solution {
    public int findTilt(TreeNode root) {
    	if(root == null)
    		return 0;
    	return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    //求整根樹的和
    public int sum(TreeNode root){
    	if(root == null)
    		return 0 ;

    	return root.val + sum(root.left) + sum(root.right);
    }
}


class Solution {
	int tilt = 0;
    public int findTilt(TreeNode root) {
    	if(root == null)
    		return 0;
    	handle(root);
    	return tilt;
    }

    //求整根樹的和
    public int handle(TreeNode root){
    	if(root == null)
    		return 0 ;

    	// base case 考察节点的左右子树为叶子节点,则子树和为叶子节点的值
    	if(root.right == null && root.left == null){
    		return root.val;
    	}

    	int left = handle(root.left);
    	int right = handle(root.right);

    	tilt += Math.abs(left - right);
    	// 将子树之和往上传递,计算父节点的坡度
    	return root.val + left + right;
    }
}