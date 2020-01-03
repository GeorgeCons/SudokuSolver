import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SudokuView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/sudokuGUI.fxml"));
        primaryStage.setTitle("Eradoku");
        primaryStage.setScene(new Scene (root,789,445));
        primaryStage.show();
    }



}


