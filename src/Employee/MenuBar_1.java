package Employee;
// Java program to create a menu bar and add 
// menu to it and also add menuitems to menu 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class MenuBar_1 extends Application
{

   // launch the application 
   public void start (Stage s)
   {
      // set title for the stage 
      s.setTitle("Employee Inventory");

      // create a menu 
      Menu m = new Menu("File");
      Menu edit = new Menu("Edit");
      Menu search = new Menu("Search");
      Menu help = new Menu("Help");

      // create menuitems 
      MenuItem m1 = new MenuItem("Open");
      MenuItem m2 = new MenuItem("Save");
      MenuItem m3 = new MenuItem("Save as...");
      MenuItem m4 = new MenuItem("Close");

      // add menu items to menu 
      m.getItems().add(m1);
      m.getItems().add(m2);
      m.getItems().add(m3);
      m.getItems().add(m4);

      // label to display events 
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
      m4.setOnAction(event);
      // create a menubar 
      MenuBar mb = new MenuBar();

      // add menu to menubar 
      mb.getMenus().add(m);
      mb.getMenus().add(edit);
      mb.getMenus().add(search);
      mb.getMenus().add(help);
      // create a VBox 
      VBox vb = new VBox(mb);

      // create a scene 
      Scene sc = new Scene(vb, 500, 300);

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
