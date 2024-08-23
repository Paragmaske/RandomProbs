package Codelit;

import java.util.*;

public class Easy {
	public static int findShortestSubArray(int[] nums) {
		int maxFreq = 0 ;
		int maxLen = 0;
		for(int i=0;i<nums.length;i++){
			int freq=0;
			int len=0;
			for(int j=i;j<nums.length;j++) {
				if(nums[j]==nums[i]) {
					freq++;
					len = j-i+1;
				}
			}
			if(freq> maxFreq){
				maxFreq = freq;
				maxLen = len;
			}
			if(maxFreq == freq){
				maxLen = Math.min(len, maxLen);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] ans = {1};
		findShortestSubArray(ans);
	}
}
