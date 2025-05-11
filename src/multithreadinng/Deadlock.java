package multithreadinng;

public class Deadlock {


    public static void main(String[] args){
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(new Task1(pen, paper), "Thread 1");
        Thread t2 = new Thread(new Task2(pen, paper),"Thread 2");

        t1.start();
        t2.start();

    }
}

class Pen {
    public synchronized void writewithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() +"is using pen " + this + "trying to use paper" + paper);
        paper.finishedWriting();
    }

    public synchronized void finishedWriting(){
        System.out.println(Thread.currentThread().getName() +"Finished writing using pen");
    }

}


class Paper {
    public synchronized  void writewithPenAndPaper(Pen pen){
        System.out.println(Thread.currentThread().getName() +"is using paper " + this + "trying to use pen" + pen);
        pen.finishedWriting();
    }

    public synchronized  void finishedWriting(){
        System.out.println(Thread.currentThread().getName() +"Finished writing using paper");
    }

}

class Task1 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper){
     this.paper = paper;
     this.pen = pen;
    }

    @Override
    public void run() {
pen.writewithPenAndPaper(paper);
    }
}



class Task2 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper){
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (pen){
            paper.writewithPenAndPaper(pen);
        }


//        paper.writewithPenAndPaper(pen); deadlock
    }
}