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
	public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getLonelyNodes(root, false, nodes);//root is not lonely
        return nodes;
    }

    private void getLonelyNodes(TreeNode root, boolean isLonely, List<Integer> nodes){
        //到了这个节点如果不存在，就刚好向上返回
        if(root == null)
            return;

        if(isLonely){
            nodes.add(root.val);
        }
        //转移到左边的子节点，顺便检查右边的子节点是否存在，如果不存在，就刚好将左边的孤单节点返回
        getLonelyNodes(root.left, root.right == null, nodes);
        getLonelyNodes(root.right, root.left == null, nodes);

    }
}


class Solution {
	public List<Integer> getLonelyNodes(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(root, null, result);
        return result; 
    }

    void helper(TreeNode root, TreeNode parent, ArrayList<Integer> result){
    	if(root == null)
    		return;

    	if(parent != null && (parent.left == null || parent.right == null)){
    		result.add(root.val);
    	}

    	helper(root.left, root, res);
    	helper(root.right, root, res);
    }

    
}
