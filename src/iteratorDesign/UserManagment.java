package iteratorDesign;

import java.util.ArrayList;

public class UserManagment {

    private ArrayList<User>  userArrayList = new ArrayList<>();

    public void addUser(User user){
        userArrayList.add(user);
    }

    public CustomIterator getIterator(){
        return new CustomeIntertaorImpl(userArrayList);
    }
}
