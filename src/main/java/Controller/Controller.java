package Controller;

import Model.SudokuSolver;

public class Controller extends Thread {
    SudokuSolver solver;



    public static void solve(final GUIController boardControl){
        final Controller control = new Controller();
        //TODO:  Get current table from Arraylist
        final int[][] tableBefore = new int[][]
                {{0, 0, 0, 0, 0, 0, 0, 0, 2},
                        {0, 2, 0, 7, 9, 5, 0, 0, 0},
                        {0, 0, 5, 2, 0, 3, 6, 0, 0},
                        {0, 6, 9, 8, 0, 7, 1, 3, 0},
                        {0, 8, 0, 0, 3, 0, 0, 4, 0},
                        {0, 3, 7, 5, 0, 4, 9, 6, 0},
                        {0, 0, 6, 9, 0, 8, 4, 0, 0},
                        {0, 0, 0, 1, 5, 6, 0, 7, 0},
                        {9, 0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] tableTest = new int[][]
                {{8, 9, 3, 4, 6, 1, 7, 5, 2},
                        {6, 2, 4, 7, 9, 5, 3, 8, 1},
                        {7, 1, 5, 2, 8, 3, 6, 9, 4},
                        {4, 6, 9, 8, 2, 7, 1, 3, 5},
                        {5, 8, 1, 6, 3, 9, 2, 4, 7},
                        {2, 3, 7, 5, 1, 4, 9, 6, 8},
                        {1, 5, 6, 9, 7, 8, 4, 2, 3},
                        {3, 4, 2, 1, 5, 6, 8, 7, 9},
                        {9, 7, 8, 3, 4, 2, 5, 1, 6}};

        control.solver = new SudokuSolver();
[]
        System.out.println("Pressed");


        Thread thread2 = new Thread() {
            public void run() {
                control.solver.solve(tableBefore,boardControl);}};
        try {
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
