package abstractFactoryDesign;

public class EmployeeFactory {
     public static Employees getEmployee(EmployeeAbstractFactory factory){
         return factory.createEmployee();

     }
}
