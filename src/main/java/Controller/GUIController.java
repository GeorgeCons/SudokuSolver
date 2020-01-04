package Controller;

import View.SudokuView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class GUIController implements Initializable {


        @FXML Button buttonReset;
        @FXML private Button buttonSolve;




        public void initialize(URL url, ResourceBundle rb) {
           // field00.setText("test");
           // buttonReset.setText("PLS");
            buttonSolve.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    Controller.solve();
                }
            });
            buttonReset.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                   // BoardController.field01.setText("9");
                }
            });
        }

        public void addEventListener (Event e) { ;
        }



}
