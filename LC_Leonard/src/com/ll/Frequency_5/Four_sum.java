package com.ll.Frequency_5;
import java.util.*;

public class Four_sum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if(len < 4) return results;
        
        Arrays.sort(num);
        for(int i = 0; i < len-3; i++) {
        	if(i != 0 && num[i] == num[i-1]) continue;
        	int sum1 = target - num[i];
        	for(int j = i+1; j < len-2; j++) {
        		if(j != i+1 && num[j] == num[j-1]) continue;
        		int sum2 = sum1 - num[j];
        		int start = j+1, end = len-1;
        		while(start < end) {
        			int sum3 = num[start] + num[end];
        			if(sum3 == sum2) {
        				ArrayList<Integer> result = new ArrayList<Integer>();
        				result.add(num[i]);
        				result.add(num[j]);
        				result.add(num[start]);
        				result.add(num[end]);
        				results.add(result);
        				start++;
        				while(start < end && num[start] == num[start-1]) start++;
        				end--;
        				while(start < end && num[end] == num[end+1]) end--;
        			} else if(sum3 > sum2) end--;
        			else start++; 
        		}
        	}
        }
        return results;
    }
}
