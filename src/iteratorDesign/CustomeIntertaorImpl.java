package iteratorDesign;

import java.util.ArrayList;
import java.util.List;

public class CustomeIntertaorImpl implements CustomIterator<User>{
    List<User> list = new ArrayList<>();
    private int length;
    private int curposition =0;

    public CustomeIntertaorImpl(List<User> list){
        this.list = list;
        this.length = list.size();
    }
    @Override
    public boolean hasNext() {
        if(curposition >= length) return false;
        return true;
    }

    @Override
    public User next() {
            User user = this.list.get(curposition);
            curposition++;
            return user;

    }
}
