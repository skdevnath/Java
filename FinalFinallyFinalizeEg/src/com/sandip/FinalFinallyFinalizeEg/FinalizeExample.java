package com.sandip.FinalFinallyFinalizeEg;

public class FinalizeExample {
	int	    instantId;
	FinalizeExample(int in) {
		this.instantId = in;
	}
    public void finalize(){
        System.out.println("finalize called for :" + instantId);
    }
    public static void test(){
        FinalizeExample f1=new FinalizeExample(1);  
        FinalizeExample f2=new FinalizeExample(2);  
        f1=null;  
        f2=null;  
        System.gc();  
    }
}
