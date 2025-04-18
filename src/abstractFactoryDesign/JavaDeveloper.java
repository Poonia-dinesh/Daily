package abstractFactoryDesign;

public class JavaDeveloper implements Employees {
    @Override
    public int salary() {
        return 200000;
    }

    @Override
    public String name() {
        return "Java Developer";
    }
}
