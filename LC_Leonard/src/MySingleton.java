
public class MySingleton {  
  
    private  static volatile MySingleton mySingleton = null;  
  
    private MySingleton(){  
       
    }  
    public static MySingleton getInstance(){  
       
        if(mySingleton == null){  
        	 synchronized(MySingleton.class){
        	 	if(mySingleton == null){
        	 		  mySingleton = new MySingleton();  
        	 	}
        	 }
        }
        return mySingleton;  
    }  
}  