package abstractFactoryDesign;

public class JavaDevFactory extends EmployeeAbstractFactory{
    @Override
    public Employees createEmployee() {
        return new JavaDeveloper();
    }
}
