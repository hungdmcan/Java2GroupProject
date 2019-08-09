package Employee;


public class Employee
{
   private String employeeID;
   private String firstName;
   private String lastName;
   private String sin;
   private String department;
   private String title;
   private String startDate;
   private String salary;
   private String maritalStatus;
   private String children;
   private String qualification;


   /**
    *
    * @param name
    * @param dep
    * @param employeeID
    */
   public Employee ()
   {
   }

   ;
   public Employee (String employeeID, String firstName, String lastName, String sin, String department, String title, String startDate, String salary, String maritalStatus, String children, String qualification)
   {
      this.employeeID = employeeID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.sin = sin;
      this.department = department;
      this.title = title;
      this.startDate = startDate;
      this.salary = salary;
      this.maritalStatus = maritalStatus;
      this.children = children;
      this.qualification = qualification;
   }

   public String getFullName ()
   {
      return (this.getFirstName() + this.getLastName());
   }

   /**
    *
    * @param name
    */
   public void setFirstName (String firstName)
   {
      this.firstName = firstName;
   }

   public String getSin ()
   {
      return this.sin;
   }

   /**
    *
    * @param sin
    */
   public void setSin (String sin)
   {
      this.sin = sin;
   }

   public String getTitle ()
   {
      return this.title;
   }

   /**
    *
    * @param Title
    */
   public void setTitle (String title)
   {
      this.title = title;
      //throw new UnsupportedOperationException();
   }

   public String getEmployeeID ()
   {
      return this.employeeID;
   }

   /**
    *
    * @param employeeID
    */
   public void setEmployeeID (String employeeID)
   {
      this.employeeID = employeeID;
   }

   /**
    * @return the firstName
    */
   public String getFirstName ()
   {
      return firstName;
   }

   /**
    * @return the lastName
    */
   public String getLastName ()
   {
      return lastName;
   }

   /**
    * @param lastName the lastName to set
    */
   public void setLastName (String lastName)
   {
      this.lastName = lastName;
   }

   /**
    * @param sin the sin to set
    */


   /**
    * @return the department
    */
   public String getDepartment ()
   {
      return department;
   }

   /**
    * @param department the department to set
    */
   public void setDepartment (String department)
   {
      this.department = department;
   }

   /**
    * @param title the title to set
    */


   /**
    * @return the startDate
    */
   public String getStartDate ()
   {
      return startDate;
   }

   /**
    * @param startDate the startDate to set
    */
   public void setStartDate (String startDate)
   {
      this.startDate = startDate;
   }

   /**
    * @return the salary
    */
   public String getSalary ()
   {
      return salary;
   }

   /**
    * @param salary the salary to set
    */
   public void setSalary (String salary)
   {
      this.salary = salary;
   }

   /**
    * @return the maritalStatus
    */
   public String getMaritalStatus ()
   {
      return maritalStatus;
   }

   /**
    * @param maritalStatus the maritalStatus to set
    */
   public void setMaritalStatus (String maritalStatus)
   {
      this.maritalStatus = maritalStatus;
   }

   /**
    * @return the children
    */
   public String getChildren ()
   {
      return children;
   }

   /**
    * @param children the children to set
    */
   public void setChildren (String children)
   {
      this.children = children;
   }

   /**
    * @return the qualification
    */
   public String getQualification ()
   {
      return qualification;
   }

   /**
    * @param qualification the qualification to set
    */
   public void setQualification (String qualification)
   {
      this.qualification = qualification;
   }

}
