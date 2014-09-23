
import java.util.*;

public class Gray_Code {
    public List<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
        int m=1<<n;
        for(int i=0; i<m ; i++) {
            result.add(i^(i>>1));
        }
        return result; 
    }
    
    
    public ArrayList<Integer> grayCode2(int n) {
    	//  http://codeganker.blogspot.com/2014/04/gray-code-leetcode.html
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n<0)
            return res;
        if(n==0)
        {
            res.add(0);
            return res;
        }
        res.add(0);
        res.add(1);
        for(int i=2;i<=n;i++)
        {
            int size = res.size();
            for(int j=size-1;j>=0;j--)
            {
                res.add(res.get(j)+(1<<(i-1)));
            }
        }
        return res;
    }
}
