public class Solution465 {
    public int minTransfers(int[][] transactions) {
    	//建立HashMap，将每个节点的盈亏情况写出来
    	//build id->debt
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
        }
        return settle(0, new ArrayList<>(m.values()));
    }
    //进行DFS
    int settle(int start, List<Integer> debt) {
    	//当前元素是否已经配平了
        while (start < debt.size() && debt.get(start) == 0)
            start++;
        //是否已经到达最后面了，可以终止循环了
        if (start == debt.size()) return 0;
        //求MIN值一定要初始化为MAX_VALUE
        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++)
        	//这判断的意思是如果有正有负，就把
            if (debt.get(start) * debt.get(i) < 0) {
            	//配平前面的节点，将正负值都加到当前的节点上
                debt.set(i, debt.get(i) + debt.get(start));
                //每次进行一次循环就是配了一次，就是+1
                r = Math.min(r, 1 + settle(start + 1, debt));
                //恢复原样，然后再对前面的再次进行DFS
                debt.set(i, debt.get(i) - debt.get(start));
            }
        return r;
    }

    public static void main(String[] args) {
        Solution465 result = new Solution465();
        int[][] transactions ={{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5},{2,1,10},{3,2,20}};
        System.out.println(result.minTransfers(transactions));
    }
}