package com.ll.Frequency_5;

public class MajorityNumber {
	/*
	 * n/2  http://www.geeksforgeeks.org/majority-element/
	 */
	static public int findCandidate(int[] nums) {
		int candidate = Integer.MIN_VALUE;
		int count;

		for (int i = count = 0; i < nums.length; i++) {
			if (count == 0) {
				candidate = nums[i];
				count = 1;
			} else {
				if (candidate == nums[i]) {
					count++;
				}  else {
					count--;
				}
			}
				
		}
		return candidate;
	}

	/*
	 * n/3
	 */
	static public int findCandidateII(int[] nums) {
		int candidateA = Integer.MIN_VALUE, candidateB = Integer.MIN_VALUE;
		int countA = 0, countB = 0;
		for (int i = 0; i < nums.length; i++) {
			if (countA == 0) {
				if (nums[i] == candidateB) {
					countB++;
				} else {
					candidateA = nums[i];
					countA++;
				}
			} else if (countB == 0) {
				if (nums[i] == candidateA) {
					countA++;
				} else {
					candidateB = nums[i];
					countB++;
				}
			} else {
				if (nums[i] == candidateA) {
					countA++;
				} else if (nums[i] == candidateB) {
					countB++;
				} else {
					countA--;
					countB--;
				}
			}
		}
		
		System.out.println(countA + "          "+ candidateA + "       " + candidateB + "       " + countB);
		if (countA > 0) {
			return candidateA;
		} else {
			return candidateB;
		}
	}

	
	static boolean checkNumber(int[] nums, int candidate) {
		int count = 0;
		for (int i = 0; i < nums.length; i++){
			if (nums[i] == candidate) {
				count++;
			}
		}
		if (count >= nums.length / 3) {
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {
		int[] nums = { 6, 6, 5, 5, 3, 3, 6, 3, 6, 5, 6, 5 };
		int majorityNum = findCandidateII(nums);
		System.out.println(majorityNum);
	}
}
