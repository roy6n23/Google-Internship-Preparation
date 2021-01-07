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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true;
        }

        return helper(root.left, root.right);

    }

    public boolean helper(TreeNode root1, TreeNode root2){
    	if(root1 == null && root2 == null)
    		return true;
    	//判断的是check(t1.left, t2.right) && check(t1.right, t2.left);直到遍历到叶子节点才能返回true，中间某部为false就终止了
    	//所以中间不能返回，必须到根节点才能返回，中间返回了true就不会递归子树了
    	if(root1 == null || root == null || root1.val != root2.val)
    		return false;

    	return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
}


//==================DFS iterative using stack

public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root.left);
        right.push(root.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode ln = left.pop();
            TreeNode rn = right.pop();
            if (ln == null && rn == null)
                continue;
            if (ln == null || rn == null)
                return false;
            if (ln.val != rn.val)
                return false;
            left.push(ln.left);
            left.push(ln.right);
            right.push(rn.right);
            right.push(rn.left);
        }
        return true;
}

//=============BFS iterative using queue=============

public boolean isSymmetric(TreeNode root){
	if(root == null)
		return true;

	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root.left);
	queue.offer(root.right);
	while(!queue.isEmpty()){
		TreeNode node1 = queue.poll();
		TreeNode node2 = queue.poll();
		if(node1 == null && node2 == null){
			continue;
		}

		if(node1 == null || node2 == null || node1.val != node2.val)
			return false;

		queue.offer(node1.left);
		queue.offer(node2.right);
		queue.offer(node1.right);
		queue.offer(node2.left);
	}

	return true;
}