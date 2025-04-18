package factoryDesign;

public class CheckEmployee {
    public static void main(String[] args){
   Employee javaEmployee = EmployeeFactory.getEmployee("Java");
   Employee androidEmployee = EmployeeFactory.getEmployee("Android");
        System.out.println(javaEmployee.salary());
        System.out.println(androidEmployee.salary());
    }
}
