package test.msft.bloomfilter;

public class BfException extends Exception{
    String msg;
    public BfException(String msg) {
        this.msg=msg;
    }
    public String toString(){
        return ("Boolfilter Error: " + msg) ;
    }
}
