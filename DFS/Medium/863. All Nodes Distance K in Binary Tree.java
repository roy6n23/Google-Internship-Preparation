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
	private Map<TreeNode, TreeNode> parents = new HashMap<>();

	private Set<TreeNode> used = new HashSet<>();

	private TreeNode targetNode;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    	find(root, null, target);

        List<Integer> result = new ArrayList<>();

        dfs(targetNode, result, K);

        return result;

    }

    private void findK(TreeNode root, TreeNode parent, TreeNode target){
    	if(root == null){
    		return;
    	}

    	if(root.val == target.val){
    		targetNode = root;
    	}

    	parent.put(root, parent);
    	find(root.left, root, target);
    	find(root.right, root, target);
    }

    private dfs(TreeNode root, List<Integer> collector, int distance){
    	if(root != null && !used.contains(root)){
    		used.add(root);
    		if(distance <= 0){
    			collector.add(root.val);
    			return;
    		}

    		dfs(root.left, collector, distance-1);
    		dfs(root.right, collector, distance-1);
    		dfs(parents.get(root), collector, distance-1);

    	}
    }
}