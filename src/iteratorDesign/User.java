package iteratorDesign;

public class User {
    private int userId;
    private String userName;

    public User(String name, int userId){
        this.userId = userId;
        this.userName = name;

    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString(){
        return userName + " : "+ userId;
    }
}
