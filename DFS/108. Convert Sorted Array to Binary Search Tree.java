/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

	public TreeNode dfs(int[] nums, int left, int right){
		if(left >= right)
			return null;
		int mid = left + (right - left)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = dfs(nums, left, mid);
		root.right = dfs(nums, mid+1, right);
		return root;
	}
	 // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums == null)
    		return null;

    	return dfs(nums, 0 , nums.length - 1);
    }
}