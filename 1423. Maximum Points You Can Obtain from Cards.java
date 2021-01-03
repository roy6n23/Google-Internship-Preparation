class Solution{
	public int maxScore(int[] cardPoints, int k){
		int[] dp = new int[k+1];

		for(int i = cardPoints.length - 1; i >= cardPoints.length-k; i--){
			dp[0] += cardPoints[i];
		}

		int max_points = dp[0];

		for(int i = 1; i <= k; i++){
			dp[i] = dp[i-1] + cardPoints[i-1] - cardPoints[cardPoints.length - k +i -1];
			max_points = Math.max(max_points, dp[i]);
		}

		return max_points;
	}
}


//没必要使用DP
public int maxScore(int[] cardPoints, int k) {
	int left = 0,right = 0;
	//先计算最右边的k个的和
	for(int i = cardPoints.length - 1;i >= cardPoints.length-k ; i--) {
		right += cardPoints[i];
	}
	//将结果先初始化为最右边的k个的和
	int result = right;
	int i=-1;
	int j=cardPoints.length-k-1;
	//记录最大值
	for(int m = 1; m <= k; m++) {
		i++;
		j++;
		left += cardPoints[i];
		right -= cardPoints[j];
		result = Math.max(result, left + right);
	}
	return result;
}