package observerDesign;


public interface Subject {
   public void subscribe(Observer observer);
   public void notifyThis();
}
