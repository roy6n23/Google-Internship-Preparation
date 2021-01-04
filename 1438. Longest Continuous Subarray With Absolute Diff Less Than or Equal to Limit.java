//sliding windows + heap(priorityqueue)
//O(N)

class Solution {
    public int longestSubarray(int[] nums, int limit) {
    	int maxLength = 0;
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

    	int windowStart = 0;

    	for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
    		minHeap.add(nums[windowEnd]);
    		maxHeap.add(nums[windowEnd]);

    		while(maxHeap.peek() - minHeap.peek() > limit){
    			minHeap.remove(nums[windowStart]);
    			maxHeap.remove(nums[windowStart]);
    			windowStart++;
    		}

    		maxLength = Math.max(maxLength, windowEnd - windowStart +1);
    	}

    	return maxLength;

    }
}