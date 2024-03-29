package Employee;
//import ReadData;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeList
{
   private List<Employee> list;

   public EmployeeList () throws Exception
   {
//      getList();
      this.list = new ArrayList<>();
   }

   public List<Employee> getList () throws FileNotFoundException
   {





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
         System.out.println(employee.toString());
         list.add(employee);




//      // Close the file
//      input.close();
      }
      return list;
   }
}
