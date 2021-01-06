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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        dfs(root1, result1);
        dfs(root2, result2);

        if(result1.size() != result2.size()){
        	return false;
        }else{
        	int size = result1.size();
        	for(int i = 0; i < size; i++){
        		if(result1.get(i) != result2.get(i))
        			return false;
        	}
        }

        return true;
    }

    public void dfs(TreeNode root, List<Integer> result){
    	if(root == null)
    		return;

    	if(root.left == null && root.right == null)
    		// result.append(root.val);
    		result.add(root.val);

    	dfs(root.left, result);
    	dfs(root.right, result);
    }
}