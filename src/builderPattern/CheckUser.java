package builderPattern;

public class CheckUser {
    public static void main(String[] args){
        User user = new User.UserBuilder().setUserName("Poonia").setUserId(1).builder();
        System.out.println(user);
    }
}
