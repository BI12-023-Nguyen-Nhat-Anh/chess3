package vn.edu.usth.ldchess;

public class ShareData {
    private static ShareData instance;
    private  String sharedString;
    private ShareData(){
        // Private constructors to prevent instantiation
    }

    protected static ShareData getInstance(){
        if(instance == null){
            instance = new ShareData();
        }
        return  instance;
    }
    public String getSharedString(){

        return sharedString;
    }
    public void setSharedString(String sharedString){
        this.sharedString = sharedString;
    }
}
