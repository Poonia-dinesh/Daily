package abstractFactoryDesign;

public class AndroidDeveloper implements Employees {
    @Override
    public int salary() {
        return 100000;
    }

    @Override
    public String name() {
        return "Android Developer";
    }
}
