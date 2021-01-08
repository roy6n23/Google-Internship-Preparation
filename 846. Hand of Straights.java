package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Roy
 * @create 2021-01-08 17:42
 */
class Solution846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand == null || hand.length % W != 0 || W == 0)
            return false;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int num:hand){
            hashMap.put(num, hashMap.getOrDefault(num,0)+1);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

        minHeap.addAll(hashMap.entrySet());


        while(!minHeap.isEmpty()){
            Map.Entry<Integer, Integer>[] temp = new Map.Entry[W];
            //注意这里要进行判断是否能一直弹出，对大小的判断
            if(minHeap.size() < W)
                return false;
            for(int i = 0; i < W; i++){
                temp[i] = minHeap.poll();
            }
            for(int i = 0; i < W; i++){
                if(!temp[i].getKey().equals(temp[0].getKey() + i ))
                    return false;
            }
            for(int i = 0; i < W; i++){
                if(temp[i].getValue() > 1){
                    temp[i].setValue(temp[i].getValue()-1);
                    minHeap.offer(temp[i]);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
		Solution846 result = new Solution846();
		int[] hand = new int[]{1,2,3,4,5};
		int W = 5;

       System.out.println(result.isNStraightHand(hand, W));

        int[] hand2 = new int[]{1,1,2,2,3,3};
        int W2 = 2;

        System.out.println(result.isNStraightHand(hand2, W2));
    }
}
