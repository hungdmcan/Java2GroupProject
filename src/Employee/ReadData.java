package Employee;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadData extends ArrayList
{

   //private List<Employee> list = new ArrayList<>();

   public ReadData () throws Exception
   {
//   public void populateList () throws FileNotFoundException
//   {

      // Create a File instance
      java.io.File file = new java.io.File("employees.csv");

      // Create a Scanner for the file
      Scanner input = new Scanner(file);
      input.useDelimiter(";");
      // Read data from a file

      while (input.hasNext()) {

         String employeeID = input.next();

         String firstName = input.next();
         String lastName = input.next();
         String sin = input.next();
         String department = input.next();
         String title = input.next();
         String startDate = input.next();
         String salary = input.next();
         String maritalStatus = input.next();
         String children = input.next();
         String qualification = input.next();
         input.nextLine();
//         System.out.println(employeeID + "     "
//                 + firstName + " " + lastName + " " + sin + "   " + department + "    " + title + "   " + startDate + "   " + salary + "   " + maritalStatus + "   " + children + "    " + qualification);
         Employee employee = new Employee(employeeID, firstName, lastName, sin, department, title, startDate, salary, maritalStatus, children, qualification);
         //System.out.println(employee.toString());
         this.add(employee);

         // Close the file
//         input.close();
      }
   }
}
