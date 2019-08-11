/*
 * Manh Hung Dao - Web Programming
 * Student ID: 991557299
 * Sheridan - Spring/Summer Semester
 */
package Employee;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EmployeeSearchView extends Application
{

   private TableView<Employee> table;
   private ObservableList<Employee> data;
   private Text actionStatus;

   //private TableView table = new TableView();

   public static void main (String[] args)
   {
      Application.launch(args);
   }

   @Override
   public void start (Stage primaryStage) throws Exception
   {

      Scene scene = new Scene(new Group());
      primaryStage.setTitle("Employee List");
      primaryStage.setWidth(1100);
      primaryStage.setHeight(700);

      final Label label = new Label("Employee List");
      label.setFont(new Font("Arial", 20));
      HBox labelHb = new HBox();
      labelHb.setAlignment(Pos.CENTER);
      labelHb.getChildren().add(label);

      table = new TableView<>();
      data = getIntialTableData();
      table.setItems(data);
      table.setEditable(true);

      TableColumn employeeIDCol = new TableColumn("Employee ID");
      employeeIDCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeID"));
      employeeIDCol.setCellFactory(TextFieldTableCell.forTableColumn());
      employeeIDCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setEmployeeID(t.getNewValue());
         }
      });
      TableColumn firstNameCol = new TableColumn("First Name");
      firstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
      firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
      firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setFirstName(t.getNewValue());
         }
      });
      TableColumn lastNameCol = new TableColumn("Last Name");
      lastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
      lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
      lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setLastName(t.getNewValue());
         }
      });
      TableColumn sinCol = new TableColumn("SIN");
      sinCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("sin"));
      sinCol.setCellFactory(TextFieldTableCell.forTableColumn());
      sinCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setSin(t.getNewValue());
         }
      });
      TableColumn departmentCol = new TableColumn("Department");
      departmentCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
      departmentCol.setCellFactory(TextFieldTableCell.forTableColumn());
      departmentCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setDepartment(t.getNewValue());
         }
      });
      TableColumn titleCol = new TableColumn("Title");
      titleCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("title"));
      titleCol.setCellFactory(TextFieldTableCell.forTableColumn());
      titleCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setTitle(t.getNewValue());
         }
      });

      TableColumn startDateCol = new TableColumn("Start Date");
      startDateCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("startDate"));
      startDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
      startDateCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setStartDate(t.getNewValue());
         }
      });
      TableColumn salaryCol = new TableColumn("Salary");
      salaryCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));
      salaryCol.setCellFactory(TextFieldTableCell.forTableColumn());
      salaryCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setSalary(t.getNewValue());
         }
      });
      TableColumn maritalCol = new TableColumn("Marital Status");
      maritalCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("maritalStatus"));
      maritalCol.setCellFactory(TextFieldTableCell.forTableColumn());
      maritalCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setMaritalStatus(t.getNewValue());
         }
      });
      TableColumn childrenCol = new TableColumn("No. of Children");
      childrenCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("children"));
      childrenCol.setCellFactory(TextFieldTableCell.forTableColumn());
      childrenCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setChildren(t.getNewValue());
         }
      });
      TableColumn qualificationCol = new TableColumn("Qualification");
      qualificationCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("qualification"));
      qualificationCol.setCellFactory(TextFieldTableCell.forTableColumn());
      qualificationCol.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>()
      {
         @Override
         public void handle (CellEditEvent<Employee, String> t)
         {

            ((Employee) t.getTableView().getItems().get(
             t.getTablePosition().getRow())).setQualification(t.getNewValue());
         }
      });

      table.setPrefWidth(1000);
      table.setPrefHeight(400);
      table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      table.getSelectionModel().selectedIndexProperty().addListener(
              new RowSelectChangeListener());

      FilteredList<Employee> flEmployee = new FilteredList(data, p -> true);//Pass the data to a filtered list

      table.setItems(flEmployee);//Set the table's items using the filtered list
      table.getColumns().addAll(employeeIDCol, firstNameCol, lastNameCol, sinCol, departmentCol, titleCol, startDateCol, salaryCol, maritalCol, childrenCol, qualificationCol);

      ChoiceBox<String> choiceBox = new ChoiceBox();
      choiceBox.getItems().addAll("First Name", "Last Name", "Employee ID");
      choiceBox.setValue("First Name");

      TextField textField = new TextField();
      textField.setPromptText("Search here!");
      textField.setOnKeyReleased(keyEvent
              -> {
         switch (choiceBox.getValue())//Switch on choiceBox value
         {
            case "First Name":
               flEmployee.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
               break;
            case "Last Name":
               flEmployee.setPredicate(p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
               break;
            case "Employee ID":
               flEmployee.setPredicate(p -> p.getEmployeeID().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
               break;
         }
      });

      choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
              -> {//reset table and textfield when new choice is selected
         if (newVal != null) {
            textField.setText("");
            flEmployee.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
         }
      });

      SortedList<Employee> sortedEmployee = new SortedList<>(flEmployee);
      sortedEmployee.comparatorProperty().bind(table.comparatorProperty());
      table.setItems(sortedEmployee);
      // Add and delete buttons
      Button addbtn = new Button("Add");
      addbtn.setOnAction(new AddButtonListener());
      Button delbtn = new Button("Delete");
      delbtn.setOnAction(new DeleteButtonListener());
      Button editbtn = new Button("Edit");
      editbtn.setOnAction(new EditButtonListener());
      Button savebtn = new Button("Save");
      savebtn.setOnAction(new SaveButtonListener());
      HBox buttonHb = new HBox(10);
      buttonHb.setAlignment(Pos.CENTER);
      buttonHb.getChildren().addAll(addbtn, delbtn, editbtn, savebtn, choiceBox, textField);

      // Status message text
      actionStatus = new Text();
      actionStatus.setFill(Color.FIREBRICK);

      // Vbox
      VBox vbox = new VBox(20);
      vbox.setPadding(new Insets(25, 25, 25, 25));;
      vbox.getChildren().addAll(labelHb, table, buttonHb, actionStatus);

      table.getColumns().addAll(employeeIDCol, firstNameCol, lastNameCol, sinCol, departmentCol, titleCol, startDateCol, salaryCol, maritalCol, childrenCol, qualificationCol);
      employeeIDCol.setMinWidth(40);
      firstNameCol.setMinWidth(30);
      lastNameCol.setMinWidth(40);
      sinCol.setMinWidth(50);

      departmentCol.setMinWidth(40);
      startDateCol.setMinWidth(50);
      salaryCol.setMinWidth(30);
      maritalCol.setMinWidth(40);
      childrenCol.setMinWidth(60);
      qualificationCol.setMinWidth(40);
      // final VBox vbox = new VBox();
//      vbox.setSpacing(5);
//      vbox.setPadding(new Insets(10, 0, 0, 10));
//      vbox.getChildren().addAll(label, table);

      ((Group) scene.getRoot()).getChildren().addAll(vbox);

      primaryStage.setScene(scene);
      primaryStage.show();
   }

   private ObservableList<Employee> getIntialTableData () throws Exception
   {
      //EmployeeList list = new EmployeeList();
      List<Employee> list = new ReadData();
      //EmployeeList list = new ArrayList<Employee>();
      //ReadData readData = new ReadData();

      // list.add(new Employee("111111", "Mike", "Dao", "11117857", "HR_ADMIN", "HR Manager", "3/13/12", "56000", "MARRIED", "1", "HIGH SCHOOL"));

      ObservableList<Employee> data = FXCollections.observableList(list);

      return data;

   }
   private class RowSelectChangeListener implements ChangeListener<Number>
   {

      @Override
      public void changed (ObservableValue<? extends Number> ov,
                           Number oldVal, Number newVal)
      {

         int ix = newVal.intValue();

         if ((ix < 0) || (ix >= data.size())) {

            return; // invalid data
         }

         Employee employee = data.get(ix);
         actionStatus.setText("Full Name: " + employee.getFullName() + "  |  ID:" + employee.getEmployeeID());
      }
   }



   private class AddButtonListener implements EventHandler<ActionEvent>
   {

      @Override
      public void handle (ActionEvent e)
      {

         // Create a new row after last row
         Employee employee = new Employee();
         data.add(employee);
         int row = data.size() - 1;

         // Select the new row
         table.requestFocus();
         table.getSelectionModel().select(row);
         table.getFocusModel().focus(row);

         actionStatus.setText("New Employee: Enter all the fields and Press <Enter>.");
      }
   }

   private class DeleteButtonListener implements EventHandler<ActionEvent>
   {

      @Override
      public void handle (ActionEvent e)
      {

         // Get selected row and delete
         int ix = table.getSelectionModel().getSelectedIndex();
         Employee employee = (Employee) table.getSelectionModel().getSelectedItem();
         data.remove(ix);
         actionStatus.setText("Deleted: " + employee.getFullName() + "   " + employee.getEmployeeID());

         // Select a row

         if (table.getItems().size() == 0) {

            actionStatus.setText("No data in table !");
            return;
         }

         if (ix != 0) {

            ix = ix - 1;
         }

         table.requestFocus();
         table.getSelectionModel().select(ix);
         table.getFocusModel().focus(ix);
      }
   }
   private class EditButtonListener implements EventHandler<ActionEvent>
   {

      @Override
      public void handle (ActionEvent e)
      {

         // Create a new row after last row
//         Employee employee = new Employee();
//         data.add(employee);
//         int row = data.size() - 1;
//
//         // Select the new row
//         table.requestFocus();
//         table.getSelectionModel().select(row);
//         table.getFocusModel().focus(row);

         actionStatus.setText("Edit Employee: Click  the fields to Edit and Press <Enter>.");
      }
   }
   private class SaveButtonListener implements EventHandler<ActionEvent>
   {

      @Override
      public void handle (ActionEvent e)
      {
         try {
            writeData();
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         // Create a new row after last row
//         Employee employee = new Employee();
//         data.add(employee);
//         int row = data.size() - 1;
//
//         // Select the new row
//         table.requestFocus();
//         table.getSelectionModel().select(row);
//         table.getFocusModel().focus(row);

         actionStatus.setText("Employee Information is saved to file!");
      }

      public void writeData () throws Exception
      {
         Writer writer = null;
         try {
            File file = new File("employees.csv");
            writer = new BufferedWriter(new FileWriter(file));
            for (Employee employee : data) {

               String text = employee.getEmployeeID() + ";" + employee.getFirstName() + ";" + employee.getLastName() + ";" + employee.getSin() + ";" + employee.getDepartment() + ";" + employee.getTitle() + ";" + employee.getStartDate() + ";" + employee.getSalary() + ";" + employee.getMaritalStatus() + ";" + employee.getChildren() + ";" + employee.getQualification() + "; \n";



               writer.write(text);
            }
         }
         catch (Exception ex) {
            ex.printStackTrace();
         }
         finally {

            writer.flush();
            writer.close();
         }
      }
   }
}
