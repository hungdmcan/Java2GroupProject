package Employee;

public class Employee
{

   private String name;
   private int sin;
   private Department department;
   private Title title;
   private int employeeID;

   /**
    *
    * @param name
    * @param dep
    * @param employeeID
    */
   public Employee (String name, Department dep, int employeeID)
   {
      // TODO - implement Employee.Employee
      throw new UnsupportedOperationException();
   }

   public String getName ()
   {
      return this.name;
   }

   /**
    *
    * @param name
    */
   public void setName (String name)
   {
      this.name = name;
   }

   public int getSin ()
   {
      return this.sin;
   }

   /**
    *
    * @param sin
    */
   public void setSin (int sin)
   {
      this.sin = sin;
   }

   public Title getTitle ()
   {
      return this.title;
   }

   /**
    *
    * @param Title
    */
   public void setTitle (int Title)
   {
      // TODO - implement Employee.setTitle
      throw new UnsupportedOperationException();
   }

   public int getEmployeeID ()
   {
      return this.employeeID;
   }

   /**
    *
    * @param employeeID
    */
   public void setEmployeeID (int employeeID)
   {
      this.employeeID = employeeID;
   }

}
