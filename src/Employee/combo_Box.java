package Employee;
// Java program to create a combo box and add event handler to it 
import javafx.application.Application;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class combo_Box extends Application
{

   // Launch the application 
   public void start (Stage stage)
   {
      // Set title for the stage 
      stage.setTitle("creating combo box ");

      // Create a tile pane 
      TilePane r = new TilePane();

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
      EventHandler<ActionEvent> event
              = new EventHandler<ActionEvent>()
      {
         public void handle (ActionEvent e)
         {
            selected.setText(combo_box.getValue() + " selected");
         }
      };

      // Set on action 
      combo_box.setOnAction(event);

      // Create a tile pane 
      TilePane tile_pane = new TilePane(combo_box, selected);

      // Create a scene 
      Scene scene = new Scene(tile_pane, 200, 200);

      // Set the scene 
      stage.setScene(scene);
      
      stage.show();
   }
   
   public static void main (String args[])
   {
      // Launch the application 
      launch(args);
   }
}
