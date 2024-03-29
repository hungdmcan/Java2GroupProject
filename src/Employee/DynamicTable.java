package Employee;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DynamicTable extends Application
{
   private static final String FILENAME = "employees.csv";

   @Override
   public void start (Stage primaryStage)
   {
      final BorderPane root = new BorderPane();
      final TableView<ObservableList<StringProperty>> table = new TableView<>();
      final TextField urlTextEntry = new TextField();
      urlTextEntry.setPromptText("Enter URL of tab delimited file");
      final CheckBox headerCheckBox = new CheckBox("Data has header line");
      urlTextEntry.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent event)
         {
            populateTable(table, urlTextEntry.getText(),
                          headerCheckBox.isSelected());
         }
      });
      HBox controls = new HBox();
      controls.getChildren().addAll(urlTextEntry, headerCheckBox);
      HBox.setHgrow(urlTextEntry, Priority.ALWAYS);
      HBox.setHgrow(headerCheckBox, Priority.NEVER);
      root.setTop(controls);
      root.setCenter(table);
      Scene scene = new Scene(root, 600, 400);
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   private void populateTable (
           final TableView<ObservableList<StringProperty>> table,
           final String urlSpec, final boolean hasHeader)
   {
      table.getItems().clear();
      table.getColumns().clear();
      table.setPlaceholder(new Label("Loading..."));
      Task<Void> task = new Task<Void>()
      {
         @Override
         protected Void call () throws Exception
         {
            BufferedReader in = getReaderFromUrl(urlSpec);
            // Header line
            if (hasHeader) {
               final String headerLine = in.readLine();
               final String[] headerValues = headerLine.split(";");
               Platform.runLater(new Runnable()
               {
                  @Override
                  public void run ()
                  {
                     for (int column = 0; column < headerValues.length; column++) {
                        table.getColumns().add(
                                createColumn(column, headerValues[column]));
                     }
                  }
               });
            }

            // Data:

            String dataLine;
            while ((dataLine = in.readLine()) != null) {
               final String[] dataValues = dataLine.split(";");
               Platform.runLater(new Runnable()
               {
                  @Override
                  public void run ()
                  {
                     // Add additional columns if necessary:
                     for (int columnIndex = table.getColumns().size(); columnIndex < dataValues.length; columnIndex++) {
                        table.getColumns().add(createColumn(columnIndex, ""));
                     }
                     // Add data to table:
                     ObservableList<StringProperty> data = FXCollections
                             .observableArrayList();
                     for (String value : dataValues) {
                        data.add(new SimpleStringProperty(value));
                     }
                     table.getItems().add(data);
                  }
               });
            }
            return null;
         }
      };
      Thread thread = new Thread(task);
      thread.setDaemon(true);
      thread.start();
   }

   private TableColumn<ObservableList<StringProperty>, String> createColumn (
           final int columnIndex, String columnTitle)
   {
      TableColumn<ObservableList<StringProperty>, String> column = new TableColumn<>();
      String title;
      if (columnTitle == null || columnTitle.trim().length() == 0) {
         title = "Column " + (columnIndex + 1);
      }
      else {
         title = columnTitle;
      }
      column.setText(title);
      column
              .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<StringProperty>, String>, ObservableValue<String>>()
              {
                 @Override
                 public ObservableValue<String> call (
                         CellDataFeatures<ObservableList<StringProperty>, String> cellDataFeatures)
                 {
                    ObservableList<StringProperty> values = cellDataFeatures.getValue();
                    if (columnIndex >= values.size()) {
                       return new SimpleStringProperty("");
                    }
                    else {
                       return cellDataFeatures.getValue().get(columnIndex);
                    }
                 }
              });
      return column;
   }

   private BufferedReader getReaderFromUrl (String urlSpec) throws Exception
   {
      URL url = new URL(urlSpec);
      URLConnection connection = url.openConnection();
      InputStream in = connection.getInputStream();
      return new BufferedReader(new InputStreamReader(in));
////   }
//private BufferedReader getReaderFromUrl (String FILENAME) throws Exception
//   {
//      BufferedReader br = new BufferedReader(new FileReader(FILENAME));
//      //URL url = new URL(urlSpec);
//      //URLConnection connection = url.openConnection();
//      InputStreamReader in = br;
//      return new BufferedReader(new InputStreamReader(in));
   }

   public static void main (String[] args)
   {
      launch(args);
   }
}
