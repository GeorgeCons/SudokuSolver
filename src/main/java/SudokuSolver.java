public class SudokuSolver {

    public  static void main(String[] args)
    { SudokuSolver solver = new SudokuSolver();

        showTable(solver.getRandomTable());
    }

    public int[][] solver (int[][] tableToSolve) {
        int[][] solved = new int[9][9];
        for (int i = 0; i<9; i++) {
            for (int j=0; j<9; j++) {

            }}

        return solved;
    }

    /**
     * Basic method that checks if the given input follows the rules of sudoku given the rules.
     * @param valueToCheck the value to be checked
     * @param x the row of the value to be inserted
     * @param y the colloum of the value to be inserted
     * @param table the current sudoku table
     * @return true if it can be inserted there or false otherwise.
     */

    public boolean checkIfValid (int valueToCheck,int x, int y, int[][] table) {
        for (int i = 0; i<9; i++) {
            if ((table[x][i] == valueToCheck) || (table[i][y] == valueToCheck) ) return false;
        }

    return true;
    }

    /**
     *  A method which prints in a semi-friendly format the output of a sudoku table.
     * @param tableToShow
     */

    public static void showTable (int[][] tableToShow) {

        for (int i = 0; i<=8; i++) {
            if (i%3==0 ) System.out.println(" ------------------------------");
            for (int j=0; j<9; j++) {
                if (j%3==0 ) System.out.print("|");
                if (tableToShow[i][j] == 0) System.out.print( "[" + " " +"]");
                System.out.print( "[" + tableToShow[i][j] +"]");


            }
            System.out.print("\n");


        }


    }

    /**
     * Simple method that makes use of the equals method and given two tables checks if the first is the same with the second.
     * @param trial
     * @param solution
     * @return
     */
    private boolean checkSolution (int[][]trial, int[][] solution) {
        return trial.equals(solution);

    }

    public int[][] getRandomTable(){
        int[][] table = new int[][]
                        {{8, 9, 3, 4, 6, 1, 7, 5, 2},
                        {6, 2, 4, 7, 9, 5, 3, 8, 1},
                        {7, 1, 5, 2, 8, 3, 6, 9, 4},
                        {4, 6, 9, 8, 2, 7, 1, 3, 5},
                        {5, 8, 1, 6, 3, 9, 2, 4, 7},
                        {2, 3, 7, 5, 1, 4, 9, 6, 8},
                        {1, 5, 6, 9, 7, 8, 4, 2, 3},
                        {3, 4, 2, 1, 5, 6, 8, 7, 9},
                        {9, 7, 8, 3, 4, 2, 5, 1, 6}};

        return table;
    }

}
