
public class how_many_1 {
  public int count_one(int n){
	  int res = 0;
	  while (n != 0) {	  
	  //if ((n & 0x8000000000000000) != 0) // for 64bit
		  if ((n & 0x80000000) != 0)
	  		res++;
	  	n = n << 1;
	  }
	  return res;
  }
  
  int bitcount( int n ){
	    int count = 0;
	    for( ; n != 0; n &= n - 1)
	        count++;
	    return count;
	}
  
  public static void main(String[] args) {
	  
	  int rst = new how_many_1().count_one(127);
	  System.out.println(rst);
 }
}
