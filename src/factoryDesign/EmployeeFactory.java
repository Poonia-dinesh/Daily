package factoryDesign;

public class EmployeeFactory {
     public static Employee getEmployee(String employeeField){
         if(employeeField.trim().equalsIgnoreCase("Java")){
             return  new JavaDeveloper();
         } else if (employeeField.trim().equalsIgnoreCase("Android")) {
             return new AndroidDeveloper();

         }
         return null;
     }
}
