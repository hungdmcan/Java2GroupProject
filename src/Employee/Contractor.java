package Employee;

public class Contractor extends Employee
{

   private String startDate;
   private String endDate;
   private final Category category = Category.CONTRACTOR;

   /**
    *
    * @param name
    * @param dep
    * @param employeeID
    * @param startDate
    * @param endDate
    */
   public Contractor (String name, Department dep, int employeeID, String startDate, String endDate)
   {
      // TODO - implement Contractor.Contractor
      throw new UnsupportedOperationException();
   }

   public void getCategory ()
   {
      // TODO - implement Contractor.getCategory
      throw new UnsupportedOperationException();
   }

   /**
    *
    * @param category
    */
   public void setCategory (int category)
   {
      // TODO - implement Contractor.setCategory
      throw new UnsupportedOperationException();
   }

   public void getAttribute ()
   {
      // TODO - implement Contractor.getAttribute
      throw new UnsupportedOperationException();
   }

   /**
    *
    * @param attribute
    */
   public void setAttribute (int attribute)
   {
      // TODO - implement Contractor.setAttribute
      throw new UnsupportedOperationException();
   }

}
