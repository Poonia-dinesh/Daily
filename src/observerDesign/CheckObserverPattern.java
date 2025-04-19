package observerDesign;

public class CheckObserverPattern {
    public static void main(String[] args){

        //Observer design pattern
        YouChannel channel = new YouChannel();
        Subscriber raj = new Subscriber();
        Subscriber John = new Subscriber();
        channel.subscribe(raj);
        channel.subscribe(John);
        channel.notifyThis();
    }
}
