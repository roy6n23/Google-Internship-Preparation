class Logger {

	private Map<String, Integer> hashMap;

    /** Initialize your data structure here. */
    public Logger() {
        hashMap = new HashMap<>();

    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

    	if(!hashMap.containsKey(message)){
    		hashMap.put(message, timestamp);
    		return true;
    	}

        if(timestamp - hashMap.get(message) >= 10){
        	hashMap.put(message, timestamp);
        	return true;
        }else {
        	return false;
        }


    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */