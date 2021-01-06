/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//===================DFS RECURSIVE=================
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<nestedList> list, int depth){
    	int sum = 0;
    	for(NestedInteger n : lists){
    		if(n.isInteger()){
    			sum += n*depth;
    		}else{
    			//getList相当于解除了嵌套，将外面的括号去掉了
    			sum += depthSum(n.getList, depth+1);
    		}
    	}

    	return sum;
    }

    //=================BFS iterative

    public int depthSum(List<NestedInteger> nestedList) {
	    if(nestedList == null){
	        return 0;
	    }
	    
	    int sum = 0;
	    int level = 1;
	    
	    Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
	    while(queue.size() > 0){
	        int size = queue.size();
	        
	        for(int i = 0; i < size; i++){
	            NestedInteger ni = queue.poll();
	            
	            if(ni.isInteger()){
	                sum += ni.getInteger() * level;
	            }else{
	                queue.addAll(ni.getList());
	            }
	        }
	        
	        level++;
	    }
	    
	    return sum;
	}


	//=================DFS   iterative

	class NestedIntegerD{
        NestedInteger ni;
        int depth;
        NestedIntegerD(NestedInteger ni, int depth){
            this.ni = ni;
            this.depth = depth;            
        }
    }
    
    public int depthSum(List<NestedInteger> nestedList) {
        Stack<NestedIntegerD> st = new Stack<>();
        for(int i=nestedList.size()-1; i>=0; i--){
            NestedInteger ni = nestedList.get(i);
            NestedIntegerD nid = new NestedIntegerD(ni, 1);
            st.push(nid);
        }
        
        int sum = 0;
        while(!st.isEmpty())
        {
            NestedIntegerD nid = st.pop();
            if(nid.ni.isInteger())
                sum+=nid.ni.getInteger()*nid.depth;
            else
            {
                for(NestedInteger item:nid.ni.getList())
                {
                    st.push(new NestedIntegerD(item, nid.depth+1));
                }
            }
        }
        return sum;
    }


    //================BFS ITERATIVE


    public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger nestedInt : nestedList) {
            queue.offer(nestedInt);
        }
        
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInt = queue.poll();
                if (nestedInt.isInteger()) {
                    sum += nestedInt.getInteger() * depth;
                } else {
                    for (NestedInteger innerInt : nestedInt.getList()) {
                        queue.offer(innerInt);
                    }
                }
            }
        }
        return sum;
    }
}


//=========DFS

public class Solution {
    private int sum;
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        sum = 0;
        for (NestedInteger nestedInt : nestedList) {
            depthSumHelper(nestedInt, 1);
        }
        return sum;
    }
    
    private void depthSumHelper(NestedInteger nestedInt, int depth) {
        if (nestedInt.isInteger()) {
            sum += depth * nestedInt.getInteger();
            return;
        }
        for (NestedInteger innerInt : nestedInt.getList()) {
            depthSumHelper(innerInt, depth + 1);
        }
    }
}

}