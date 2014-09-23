package com.ll.DP;

public class Decode_Ways {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0' ){
     	   return 0;
        }
        if (s.length() == 1){
        	return 1;
        }
       int[] rst = new int[s.length()]; //save status : how many solutions with i numbers
       rst[0] = 1;
       rst[1] = s.charAt(0) != '0' ? 1 : 0;   // '0' has to combine with former number, otherwise invalided
       
       for (int i = 2; i <= s.length(); i++){
    	   if (s.charAt(i - 1) == '0'){
    		   if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2'){
    			   rst[i] = rst[i - 2];          // 10, 20  res[i] = res[i - 2]
    		   } else {
    			   return 0;
    		   }
    	   } else if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')){  //  11-19, 21-26 res[i] = res[i - 1]+res[i - 2]
    		   rst[i] = rst[i - 1] + rst[i - 2];
    	   } else {
    		   rst[i] = rst[i - 1];   //  01-09, 27-99£ºres[i] = res[i - 1] 
    	   }
       }
       return rst[s.length()];
       
    }
}
