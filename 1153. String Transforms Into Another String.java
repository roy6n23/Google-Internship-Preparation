class Solution {
    public boolean canConvert(String str1, String str2) {
    	if(str1.length != str2.length)
    		return false;

        int count1 = 0, count2 = 0;
        Map<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        for(int i = 0; i < str1.length; i++){
        	if(!hashMap.containsKey(count1)){
        		hashMap.put(count1, new ArrayList<Integer>(Arrays.asList(i)));
        		count1++;
        	}else{
        		hashMap.get(count1).append(i);
        	}
        }

        for(int i = 0; i < str2.length; i++){
        	if(!hashMap.containsKey(count2)){
        		return false;
        	}else {
        		ArrayList<Integer> temp = hashMap.get(count2);
        	}
        }
    }
}

class Solution {
    public boolean canConvert(String str1, String str2) {
    	if(s1.equals(s2))
    		return true;

    	Map<Character, Character> dp = new HashMap<>();
    	for(int i = 0; i < s1.length(); i++){
    		if(dp.getOrDefault(s1.charAt(i), s2.charAt(i)) != s2.charAt(i))
    			return false;
    		dp.put(s1.charAt(i), s2.Character(i));
    	}

    	return new HashSet<Character>(dp.values()).size() < 26;
    }
}