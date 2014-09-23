package com.ll.DP;


/*
 *  state: f[i]  
 *  f[0] = true
 *  function :  f[i] = f[j] && f[j] can reach i
 *  answer : f[n - 1]
 *  
 */
public class Jump_game {
	public boolean canJump(int[] A) {
		boolean can[] = new boolean[A.length];
		can[0] = true;
		for (int i = 0; i < A.length; i++){
			for (int j = 0; j < i; j++){
				if (can[j] && j + A[j] >= i){
					can[i] = true;
					break;
				}
			}
		}
		return can[A.length - 1];
	}
	
	/*
	 * Jump game II
	 * 
	 *  state: step[i]  min step
	 *  step[0] = 0;
	 *  function :  step[j]  && j + A[j] >= i       step[i] = step[j] + 1
	 *  answer : step[n - 1]
	 */
	
    public int jump(int[] A) {
    	int step[] = new int[A.length];
    	step[0] = 0;
    	for (int i = 1; i < A.length; i++){
    		step[i] = Integer.MAX_VALUE;
    		for (int j = 0; j < i; j++){
    			if (step[j] != Integer.MAX_VALUE && j + A[j] >= i){
    				step[i] = step[j] + 1;
    				break;
    			}
    		}
    	}
    	return step[A.length - 1];
        
    }
	
	
	
	
	
	
	
	
	
	
}
