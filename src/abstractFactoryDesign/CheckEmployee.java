package abstractFactoryDesign;

public class CheckEmployee {
    public static void main(String[] args){
        Employees employees = EmployeeFactory.getEmployee(new AndroidDevFactory());
        Employees javaEmployee = EmployeeFactory.getEmployee(new JavaDevFactory());
        System.out.println(employees.name());
        System.out.println(javaEmployee.name());


    }
}
