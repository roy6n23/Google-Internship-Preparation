class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	if(pushed.length != popped.length)
            return false;
    	Deque<Integer> stack = new ArrayDeque<>();
    	//LinkedList<Integer> stack = new LinkedList<>();
    	int j = 0;
    	for(int i = 0; i < pushed.length; i++){
    		stack.push(pushed[i]);
    		while(! stack.isEmpty() && stack.peek() == popped[j]){
    			j++;
    			stack.pop();
    		}
    	}

    	return stack.isEmpty();
    }
}