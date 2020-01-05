package Controller;

import Model.SudokuSolver;
import View.SudokuView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;


public class GUIController extends Thread  implements Initializable {



        @FXML Button buttonReset;
        @FXML private Button buttonSolve;

    // --- All text areas --
    @FXML private TextField field00;
    @FXML public TextField field01;
    @FXML private TextField field02;
    @FXML private TextField field03;
    @FXML private TextField field04;
    @FXML private TextField field05;
    @FXML private TextField field06;
    @FXML private TextField field07;
    @FXML private TextField field08;

    @FXML private TextField field10;
    @FXML private TextField field11;
    @FXML private TextField field12;
    @FXML private TextField field13;
    @FXML private TextField field14;
    @FXML private TextField field15;
    @FXML private TextField field16;
    @FXML private TextField field17;
    @FXML private TextField field18;

    @FXML private TextField field20;
    @FXML private TextField field21;
    @FXML private TextField field22;
    @FXML private TextField field23;
    @FXML private TextField field24;
    @FXML private TextField field25;
    @FXML private TextField field26;
    @FXML private TextField field27;
    @FXML private TextField field28;

    @FXML private TextField field30;
    @FXML private TextField field31;
    @FXML private TextField field32;
    @FXML private TextField field33;
    @FXML private TextField field34;
    @FXML private TextField field35;
    @FXML private TextField field36;
    @FXML private TextField field37;
    @FXML private TextField field38;

    @FXML private TextField field40;
    @FXML private TextField field41;
    @FXML private TextField field42;
    @FXML private TextField field43;
    @FXML private TextField field44;
    @FXML private TextField field45;
    @FXML private TextField field46;
    @FXML private TextField field47;
    @FXML private TextField field48;

    @FXML private TextField field50;
    @FXML private TextField field51;
    @FXML private TextField field52;
    @FXML private TextField field53;
    @FXML private TextField field54;
    @FXML private TextField field55;
    @FXML private TextField field56;
    @FXML private TextField field57;
    @FXML private TextField field58;

    @FXML private TextField field60;
    @FXML private TextField field61;
    @FXML private TextField field62;
    @FXML private TextField field63;
    @FXML private TextField field64;
    @FXML private TextField field65;
    @FXML private TextField field66;
    @FXML private TextField field67;
    @FXML private TextField field68;

    @FXML private TextField field70;
    @FXML private TextField field71;
    @FXML private TextField field72;
    @FXML private TextField field73;
    @FXML private TextField field74;
    @FXML private TextField field75;
    @FXML private TextField field76;
    @FXML private TextField field77;
    @FXML private TextField field78;

    @FXML private TextField field80;
    @FXML private TextField field81;
    @FXML private TextField field82;
    @FXML private TextField field83;
    @FXML private TextField field84;
    @FXML private TextField field85;
    @FXML private TextField field86;
    @FXML private TextField field87;
    @FXML private TextField field88;


    private ArrayList<TextField> board = new ArrayList<TextField>();
GUIController INSTANCE;



    public void initialize(URL url, ResourceBundle rb) {
        this.INSTANCE = this;
        addAllToBoard();
        setLimiter();
        final int[][] table = new int[][]
                {{0, 0, 0, 0, 0, 0, 0, 0, 2},
                        {0, 2, 0, 7, 9, 5, 0, 0, 0},
                        {0, 0, 5, 2, 0, 3, 6, 0, 0},
                        {0, 6, 9, 8, 0, 7, 1, 3, 0},
                        {0, 8, 0, 0, 3, 0, 0, 4, 0},
                        {0, 3, 7, 5, 0, 4, 9, 6, 0},
                        {0, 0, 6, 9, 0, 8, 4, 0, 0},
                        {0, 0, 0, 1, 5, 6, 0, 7, 0},
                        {9, 0, 0, 0, 0, 0, 0, 0, 0}};
       int[][] table2 = SudokuSolver.cloneArray(table);

        updateTable(table2);

            buttonSolve.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    Controller.solve(INSTANCE);
                }
            });
            buttonReset.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    updateTable(getResetTable());
                }
            });
        }

        public int[][] getResetTable () {
            int[][] table = new int[][]
                    {{0, 0, 0, 0, 0, 0, 0, 0, 2},
                            {0, 2, 0, 7, 9, 5, 0, 0, 0},
                            {0, 0, 5, 2, 0, 3, 6, 0, 0},
                            {0, 6, 9, 8, 0, 7, 1, 3, 0},
                            {0, 8, 0, 0, 3, 0, 0, 4, 0},
                            {0, 3, 7, 5, 0, 4, 9, 6, 0},
                            {0, 0, 6, 9, 0, 8, 4, 0, 0},
                            {0, 0, 0, 1, 5, 6, 0, 7, 0},
                            {9, 0, 0, 0, 0, 0, 0, 0, 0}};
            return table;
        }

    public void updateTable (int[][] sudokuBoard) {
        int k = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Integer number = sudokuBoard[i][j];
                this.board.get(k).setText(number.toString());
                k++;
            }
        }

    }

    private void setLimiter (){
        for (TextField field : board) {
            addTextLimiter(field,1);
        }
    }


    private static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {

            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }




    /**
     * Adds all the Text Field to the array.
     */
    public void addAllToBoard() {
        Collections.addAll(this.board, new TextField[]{
                field00,
                field01,
                field02,
                field03,
                field04,
                field05,
                field06,
                field07,
                field08,

                field10,
                field11,
                field12,
                field13,
                field14,
                field15,
                field16,
                field17,
                field18,

                field20,
                field21,
                field22,
                field23,
                field24,
                field25,
                field26,
                field27,
                field28,

                field30,
                field31,
                field32,
                field33,
                field34,
                field35,
                field36,
                field37,
                field38,

                field40,
                field41,
                field42,
                field43,
                field44,
                field45,
                field46,
                field47,
                field48,

                field50,
                field51,
                field52,
                field53,
                field54,
                field55,
                field56,
                field57,
                field58,

                field60,
                field61,
                field62,
                field63,
                field64,
                field65,
                field66,
                field67,
                field68,

                field70,
                field71,
                field72,
                field73,
                field74,
                field75,
                field76,
                field77,
                field78,

                field80,
                field81,
                field82,
                field83,
                field84,
                field85,
                field86,
                field87,
                field88});
    }





}
