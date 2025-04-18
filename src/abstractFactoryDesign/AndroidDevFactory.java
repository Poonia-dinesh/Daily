package abstractFactoryDesign;


public class AndroidDevFactory extends EmployeeAbstractFactory{
    @Override
    public Employees createEmployee() {
        return new AndroidDeveloper();
    }
}
