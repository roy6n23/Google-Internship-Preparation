class Solution {
    public String minWindow(String str, String pattern) {
        int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
        Map<Character, Character> charFreqMap = new HashMap<>();
        for(char chr : pattern.toCharArray()){
        	charFreqMap.put(chr, charFreqMap.getOrDefault(chr, 0) + 1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
        	char rightChar = str.charAt(windowEnd);
        	if(charFreqMap.containsKey(rightChar)){
        		charFreqMap.put(rightChar, charFreqMap.get(rightChar)-1);
        		if(charFreqMap.get(rightChar) >= 0)
        			matched++;
        	}

        	while(matched == pattern.length()){
        		if(minLength > windowEnd - windowStart + 1){
        			minLength = windowEnd - windowStart + 1;
        			subStrStart = windowStart;
        		}
        		char leftChar = str.charAt(windowStart++);
        		if(charFreqMap.containsKey(leftChar)){
        			if(charFreqMap.get(leftChar) == 0)
        				matched--;
        			charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
        		}
        	}

        }

        return minLength >= str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }
}