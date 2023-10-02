package vn.edu.usth.ldchess;

public class Lesson {
    private int resourceId;
    private String name;

    public Lesson (int resourceId,String name){
        this.resourceId = resourceId;
        this.name = name;
    }

    public int getResourceId(){
        return resourceId;
    }

    public  void setResourceId(){
        this.resourceId = resourceId;
    }

    public String getName(){
        return name;

    }

    public void  setName(String name){
        this.name = name;
    }
}
