//他马勒戈壁 这个数组越界问题我搞不明白了

public class Solution809 {
    public int expressiveWords(String S, String[] words) {
        //遇到问题就是不会进行跳出循环，写的很复杂
        //解答是利用了boolean进行了判断，我也可以
        //也可以添加一个状态变量，如果不满足就变成false
        int result = 0;
        //分别对每个word进行判断，把Index换成index-1会不会好一点--我他妈也不会
        for(String word : words){
            int index1 = 1, index2= 1;
            boolean state = true;

            while(index1 <= S.length() && index2 <= word.length()){
                if(S.charAt(index1-1) == (word.charAt(index2-1))){
                    int count1 = 1, count2  =1;
                    while(S.charAt(index1-1) == (S.charAt(index1))){
                        index1++;
                        count1++;
                    }
                    index1++;
                    //不能直接进行判断，因为可能存在长度一样的，所以我们只能对长度不一样的进行扩展比较，所以要跳过长度一样甚至
                    //比较小的，所以要进行记录，不能直接进行比较
                    while(word.charAt(index2-1) == word.charAt(index2)){
                        index2++;
                        count2++;
                    }
                    index2++;

                    if(count1 != count2 && (count1 < 3 || count1 < count2))
                        state = false;

                }else {
                    state = false;
                }
            }

            if(index1 != S.length()-1 || index2 != word.length()-1)
                state = false;

            if(state)
                result++;
        }

        return result;
    }


public int expressiveWords(String S, String[] words) {
        //遇到问题就是不会进行跳出循环，写的很复杂
        //解答是利用了boolean进行了判断，我也可以
        int result = 0;
        //分别对每个word进行判断，把Index换成index-1会不会好一点
        //有一个移动的，能方便地进行移动和比较
        for(String word : words){
            int index1 = 0, index2= 0;
            boolean state = true;

            while(index1 <= S.length()-1 && index2 <= word.length()-1){

                if(S.charAt(index1) == (word.charAt(index2))){
                    int count1 = index1, count2 = index2;
                    //刚好到达下一个位置
                    while(index1 <= S.length()-1 && S.charAt(count1) == (S.charAt(index1))){
                        index1++;
                    }
                    //为什么这个方法在末尾可以呢？？ 因为他不强制取index+1的位置，先进行判断之后再考虑是不是存在这个位置

                    //不能直接进行判断，因为可能存在长度一样的，所以我们只能对长度不一样的进行扩展比较，所以要跳过长度一样甚至
                    //比较小的，所以要进行记录，不能直接进行比较
                    while(index2 <= word.length()-1 && word.charAt(count2) == word.charAt(index2)){
                        index2++;
                    }

                    count1 = index1 - count1;
                    count2 = index2 - count2;

                    if(count1 != count2 && (count1 < 3 || count1 < count2))
                        state = false;

                }else {
                    state = false;
                    break;
                }
            }

            if(index1 != S.length() || index2 != word.length())
                state = false;

            if(state)
                result++;
        }

        return result;
    }

    
    public static void main(String[] args) {
        Solution809 salute = new Solution809();
        String S = "heeellooo";
        String[] words = new String[]{"hello", "hi", "helo"};

        System.out.println(salute.expressiveWords(S, words));

    }
}
