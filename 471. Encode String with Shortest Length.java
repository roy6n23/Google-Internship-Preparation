public class Solution{
	public String encode(String s){
		//dp[i][j] = string from index i to index j in encoded form.表示从i到j能省略成的形式
		//最后输出的必然是dp[0][s.length()-1]
		String[][] dp = new String[s.length()][s.length()];
		//length代表区间的长度
		for(int length = 0; length < s.length(); length++){
			//i代表开始的index
			for(int i = 0; i < s.length()-length; i++){
				//j代表结束的index
				int j = i + l;
				//substring前闭后开，只包括前面不包括后面
				String substr = s.substring(i,j+1);
				// Checking if string length < 5. In that case, we know that encoding will not help.
				if(j - i < 4){
					dp[i][j] = substring;
				}else {
					dp[i][j] = substring;
					// Loop for trying all results that we get after 
					//dividing the strings into 2 and combine the results of 2 substrings
					for(int k = i; k < j; k++){
						if((dp[i][k].length() + dp[k+1][j].length()) < dp[i][j].length){
							dp[i][j] = dp[i][k] + dp[k+1][j];
						}
					}

					//将重复的子序列进行合并
					for(int k = 0; k < substr.length(); k++){
						//对这个序列进行循环判断
						String repeatStr = substr.substring(0,k+1);
						if(repeatStr != null 
							&& substr.length()%repeatStr.length() == 0
							//是否能完全替代（意思就是是否是整循环）
							&& substr.replaceAll(repeatStr,"").length() == 0){
							String ss = substr.length()/repeatStr.length() + "[" + dp[i][i+k] + "]";
							if(ss.length() < dp[i][j].length())
								dp[i][j] = ss;
						}
					}
				}
			}
		}

		return dp[0][s.length()-1]
	}
}