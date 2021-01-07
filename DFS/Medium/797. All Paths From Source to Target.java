

//回溯法，剪枝了的方法，就是用DFS
//将部分路径作为参数传递下去，非全局变量
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    	List<List<Integer>> res = new ArrayList<>();
    	List<Integer> path = new ArrayList<>();
    	path.add(0);
    	helper(0, path, res, graph);
    	return res;
    }

    private void helper(int index, List<Integer> path, List<List<Integer>> res, int[][] graph){
    	if(index > graph.length - 1)
    		return;

    	if(index == graph.length - 1){
    		res.add(new ArrayList<Integer>(path));
    		return;
    	}


    	int[] dresses = graph[index];

    	for(int i = 0; i < dresses.length; i++){
    		path.add(dresses[i]);
    		helper(dresses[i], path, res, graph);
    		path.remove(path.size()-1);
    	}
    }
}

//设置结果为全局变量
class Solution {
	List<List<Integer>> res = null;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    	res = new ArrayList<>();
    	if(graph[0] == null)
    		return res;

    	int des = graph.length - 1;
    	dfs(0, des, graph, new ArrayList<>());
    	return res;
    }

    private void dfs(Integer st, int ed, int[][] graph, List<Integer> tem){
    	if(st == null)
    		return;

    	tem.add(st);
    	if(st == ed){
    		res.add(new ArrayList<>(tem));
    	}

    	for(Integer g : graph[st]){
    		dfs(g, ed, graph, tem);
    		tem.remove(tem.size()-1);
    	}
    	return;
    }
}

//利用是否访问的节点进行回溯的方法
class Solution {
	List<List<Integer>> ans;
    boolean [] visited ;    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.ans = new ArrayList<>();
        this.visited = new boolean[graph.length];
        dfs(graph,0,new ArrayList<>());
        return ans;
    }
    private void dfs(int [][] graph,int n,List<Integer> list){
        if(n==graph.length-1){
            list.add(n);
            ans.add(new ArrayList<>(list));
            return;
        }
        visited[n]=true;
        list.add(n);
        for(int node:graph[n]){
            if(visited[node]||graph[n].length==0)   continue; 
            dfs(graph,node,list);
            list.remove(list.size()-1);
            visited[n] = false;
        }
    }
}