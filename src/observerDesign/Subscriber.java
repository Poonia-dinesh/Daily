package observerDesign;

import javax.xml.transform.Source;

public class Subscriber implements Observer{
    @Override
    public void notified() {
        System.out.println("New Notification");
    }
}
