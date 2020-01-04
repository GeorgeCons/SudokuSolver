package View;

import Controller.GUIController;
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
    GUIController controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/sudokuGUI.fxml"));
        Parent root =  loader.load();
        Scene scene =  new Scene(root);
        this.controller =  loader.getController();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Eradoku");
        //primaryStage.setScene(new Scene (root,789,445));
        primaryStage.show();



    }
    public GUIController getController (){
        return this.controller;
    }




}


