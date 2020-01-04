import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SudokuView extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root =  FXMLLoader.load(getClass().getClassLoader().getResource("fxml/sudokuGUI.fxml"));
        Scene scene =  new Scene(root);
        //FXMLController controller =  loader.getController();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Eradoku");
        //primaryStage.setScene(new Scene (root,789,445));
        primaryStage.show();



    }




}


