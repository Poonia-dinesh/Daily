package observerDesign;

import java.util.ArrayList;
import java.util.List;

public class YouChannel implements Subject {

    List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void notifyThis() {
        for(Observer o : subscribers){
            o.notified();
        }
    }


}
