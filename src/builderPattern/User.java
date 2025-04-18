package builderPattern;

public class User {

    private final int userId;
    private final String userName;

    private User(UserBuilder builder){
        this.userId = builder.userId;
        this.userName = builder.userName;

    }

    @Override
    public String toString(){
        return this.userName + this.userId;
    }
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }


    // inner class
    static class UserBuilder {
        private  int userId;
        private  String userName;

        public UserBuilder(){

        }

        public UserBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return  this;
        }

        public User builder(){
            User user = new User(this);
            return user;
        }
    }
}
