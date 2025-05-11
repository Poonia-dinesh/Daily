package multithreadinng;

public class Main extends Thread{

    @Override
    public void run(){

    }



    public static void main(String[] args){
        Main main = new Main();
        System.out.println(Thread.currentThread().getState());
        System.out.println(main.getState());
        main.start();
        System.out.println(main.getState());

    }
}
