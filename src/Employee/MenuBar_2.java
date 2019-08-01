// Java program to create a menu bar and add menu to 
// it and also add menuitems to menu and also add 
// an event listener to handle the events 
import Employee.Department;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class MenuBar_2 extends Application
{

   // launch the application 
   public void start (Stage s)
   {
      // set title for the stage 
      s.setTitle("creating MenuBar");

      // create a menu 
      Menu m = new Menu("File");
      Menu edit = new Menu("Edit");
      Menu search = new Menu("Search");
      Menu help = new Menu("Help");
      // create menuitems 
      MenuItem m1 = new MenuItem("Open");
      MenuItem m2 = new MenuItem("Save");
      MenuItem m3 = new MenuItem("Close");

      // add menu items to menu 
      m.getItems().add(m1);
      m.getItems().add(m2);
      m.getItems().add(m3);

      // label to display events 
      Label l = new Label("\t\t\t\t"
              + "no menu item selected");

      // create events for menu items 
      // action event 
      EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()
      {
         public void handle (ActionEvent e)
         {
            l.setText("\t\t\t\t" + ((MenuItem) e.getSource()).getText()
                    + " selected");
         }
      };

      // add event 
      m1.setOnAction(event);
      m2.setOnAction(event);
      m3.setOnAction(event);

      // create a menubar 
      MenuBar mb = new MenuBar();

      // add menu to menubar 
      mb.getMenus().add(m);
      mb.getMenus().add(edit);
      mb.getMenus().add(search);
      mb.getMenus().add(help);
      // create a VBox 
      VBox vb = new VBox(mb, l);
      TilePane r = new TilePane();
      GridPane grid = new GridPane();
      // Create a label 
      Label description_label
              = new Label("This is a combo box example ");

      // Weekdays 
      Department dept[] = {Department.HR_ADMIN, Department.PROJECT_MANAGEMENT, Department.SALES_MARKETING, Department.TECHNICAL_ENGINEERING};

      // Create a combo box 
      ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(dept));

      // Label to display the selected menuitem 
      Label selected = new Label("default item selected");
      combo_box.setPromptText("Choose a Department");

      // Create action event 
//      EventHandler<ActionEvent> event
//              = new EventHandler<ActionEvent>()
//      {
//         public void handle (ActionEvent e)
//         {
//            selected.setText(combo_box.getValue() + " selected");
//         }
//      };

      // Set on action 
      combo_box.setOnAction(event);

      // Create a tile pane 
      TilePane tile_pane = new TilePane(combo_box, selected);
      grid.add(vb, 0, 0);
      grid.add(tile_pane, 0, 4);

      // create a scene 
//      Scene sc = new Scene(vb, 500, 300);
//      Scene sc1 = new Scene(tile_pane, 500, 300);
      Scene sc = new Scene(grid, 500, 300);
//      s.setScene(sc1);
      // set the scene 
      s.setScene(sc);

      s.show();
   }

   public static void main (String args[])
   {
      // launch the application 
      launch(args);
   }
}
