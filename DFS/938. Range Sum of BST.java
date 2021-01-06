/**
 * @author Roy
 * @create 2021-01-06 10:21
 */
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
class Solution938 {
//    public int rangeSumBST(TreeNode root, int low, int high) {
//        int result = 0;
//        findAllNode(root, low, high, result);
//        return result;
//    }
//
//    private void findAllNode(TreeNode root, int low, int high, int result){
//        if(root == null){
//            return;
//        }
//
//        if(root.val >= low && root.val <= high){
//            result += root.val;
//        }
//
//        findAllNode(root.left, low, high, result);
//        findAllNode(root.right, low, high, result);
//
//    }
    //===========RECURSIVE===========
    public int rangeSumBST(TreeNode root, int low, int high) {
        //base case
        if(root == null)
            return 0;
        //left excluded
        if(root.val < low)
            return rangeSumBST(root.right, low, high);
        if(root.val > high)
            return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }

    //============RECURSIVE===============
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;

        int sum = 0;
        // left child is a possible candidate.
        if(root.val > low)
            sum += rangeSumBST(root.left, low, high);
        // right child is a possible candidate.
        if(root.val < high)
            sum += rangeSumBST(root.right, low, high);

        if(root.val >= low && root.val <= high)
            sum += root.val;

        return sum;

    }

    //==============ITERATIVE================
    public int rangeSumBSTIterative(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            if(n == null)
                continue;
            if(n.val > low)
                stack.push(n.left);
            if(n.val < high)
                stack.push(n.right);
            if( n.val >= low && n.val <= high)
                sum += n.val;
        }
        
        return sum;
    }
}