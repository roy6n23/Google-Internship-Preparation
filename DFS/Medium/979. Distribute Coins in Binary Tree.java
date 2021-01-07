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
	/**
     * 从后序遍历的第一个叶子节点开始，假设自己有x个金币，剩余x-1个金币都还给父节点，x-1可能为负数、0、正数
     * x-1 < 0说明不够金币，需要从父节点获得，因此子节点有|x-1|个入方向的操作，次数加上|x-1|
     * x-1 == 0说明刚好，无需与父节点有金币的交换，次数加0
     * x-1 > 0 说明有多余的金币，需要交给父节点，因此子节点有x-1个出方向的操作，次数加上|x-1|
     */
	private int ans = 0;
    public int distributeCoins(TreeNode root) {
    	lrd(root);
    	return ans;
    }

    public int lrd(TreeNode root){
    	if(root == null)
    		return 0;

    	if(root.left != null){
    		root.val += lrd(root.left);
    	}

    	if(root.right != null){
    		root.val += lrd(root.right);
    	}

    	ans += Math.abs(root.val - 1);
    	return root.val - 1;
    }
}


class Solution {
    int sum = 0;
    public int distributeCoins(TreeNode root) {
        getSum(root);
        return sum;
    }
	int getSum(TreeNode root) {
		if(root==null) return 0;
		int l = getSum(root.left);//负数表示左节点需要扣除的金币，需要从根节点搬金币下去；正数表示多出的金币，需要将多出的金币搬上去；
		int r = getSum(root.right);//负数表示右节点需要扣除的金币，需要从根节点搬金币下去；正数表示多出的金币，需要将多出的金币搬上去；
		
		sum += Math.abs(l)+Math.abs(r);//计算路径（金币数的绝对值就是路径）
		
		return l+r+root.val-1;//返回节点的金币量（已经扣除本身以及左、右子节点需要的）
	}
}