package com.ll.recursion;

import java.util.*;

/***
 * @author Le
 *
 *         Given a set of distinct integers, S, return all possible subsets.
 * 
 *         Note: Elements in a subset must be in non-descending order. The
 *         solution set must not contain duplicate subsets. For example, If S =
 *         [1,2,3], a solution is:
 * 
 *         [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 *
 */

public class Subsets {

//       public ArrayList<ArrayList<Integer>> subsets(int[] S) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        if(S == null || S.length == 0) {
//            return result;
//        }
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        Arrays.sort(S);  
//        subsetsHelper(result, list, S, 0);
//
//        return result;
//    }
//
//
//    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
//        ArrayList<Integer> list, int[] S, int pos) {
//
//        result.add(new ArrayList<Integer>(list));
//
//        for (int i = pos; i < S.length; i++) {
//            list.add(S[i]);
//            subsetsHelper(result, list, S, i + 1);
//            list.remove(list.size() - 1);
//        }
//    }
    
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	     ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
	     res.add(new ArrayList<Integer>());
	     if(S == null || S.length == 0)
	        return res;
	    Arrays.sort(S);
	    for(int i=0;i<S.length;i++)
	    {
	        int size = res.size();
	        System.out.println(size);
	        for(int j=0;j<size;j++)
	        {
	            ArrayList<Integer> item = new ArrayList<Integer>(res.get(j));
	            item.add(S[i]);
	            res.add(item);
	        }
	    }
	    return res;
	}
    
	
	public static void main(String[] args) {
		int[] S = {1,2,3};
		Subsets test= new Subsets();
		
		for(ArrayList<Integer> item : test.subsets(S)){
			System.out.println(item);
		}
	}

}
