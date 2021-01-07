/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//将结果一并传入，方便进行记录，递归自动隐含String s 的回溯过程，直接就当成形参传递出去
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> result = new ArrayList<>();
    	if(root == null)
    		return result;

    	solve(root, "", result);
    	return result;
    }

    public void solve(TreeNode root, String cur, List<String> result){
    	if(root == null)
    		return;
    	cur += root.val;
    	if(root.left ==null && root.right == null){
    		result.add(cur);
    	}else{
    		//将当前路径字符串当成参数进行传递。这样也不需要做剪枝了。
    		solve(root.left, cur+"->", result);
    		solve(root.right, cur+"->", result);
    	}
    }
}

//将result设为全局变量，因为它根本不用变，直接在后面加就行了
class Solution {
	private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
    	dfs(root, new StringBuilder());
    	return result;
    }

    public void dfs(TreeNode root, StringBuilder sb){
    	if(root == null)
    		return;
    	sb.append(root.val);
    	if(root.left ==null && root.right == null){
    		result.add(sb.toString());
    		return;
    	}
    	//每次都要new一下，不重新new的话传入的是同一个引用
    	if(root.left != null)
    		dfs(root.left, new StringBuilder(sb).append("->"));
    	if(root.right != null)
    		dfs(root.right, new StringBuilder(sb).append("->"));
    	
    }
}
//剪枝的做法
class Solution {
	List<List<Integer>> res = new ArrayList<>();//存放所有的路径
	List<Integer> cur = new ArrayList<>();//存放当前遍历到了的节点
	
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> ans = new ArrayList<>();//最终的答案
    	if(root == null)
    		return ans;
    	dfs(root);
    	for(List<Integer> path : res){
    		StringBuilder sb = new StringBuilder();
    		sb.append(path.get(0));
    		for(int i = 1; i < path.size(); i++){
    			sb.append("->").append(path.get(i));
    		}

    		ans.add(sb.toString());
    	}

    	return ans;
    }

    public void dfs(TreeNode root){
    	cur.add(root.val);
    	//到最后再把路径加进去，所以要不断退回，所以要剪枝
    	if(root.left == null && root.right == null){
    		List<Integer> cur0 = new ArrayList<>(cur);
    		res.add(cur0);
    	}

    	if(root.left != null){
    		dfs(root.left);
    	}

    	if(root.right != null){
    		dfs(root.right);
    	}
    	cur.remove(cur.size()-1);//做剪枝，删除用掉了的叶子节点
    }
}
