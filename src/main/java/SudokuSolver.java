

public class SudokuSolver {

    public  static void main(String[] args)
    { SudokuSolver solver = new SudokuSolver();

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


        showTable(table);
        //System.out.println(solver.checkIfValid(2,6,5,table));
        showTable(solver.solve(table));
    }

    /**
     * Method which implements backtracking to solve the table. Implementation done through iteration.
     * Possible to do through recursion as well.
     * @param tableToSolve
     * @return
     */
    public int[][] solve (int[][] tableToSolve) {
         int[][] saved = new int[][]
                 {{0, 0, 0, 0, 0, 0, 0, 0, 2},
                         {0, 2, 0, 7, 9, 5, 0, 0, 0},
                         {0, 0, 5, 2, 0, 3, 6, 0, 0},
                         {0, 6, 9, 8, 0, 7, 1, 3, 0},
                         {0, 8, 0, 0, 3, 0, 0, 4, 0},
                         {0, 3, 7, 5, 0, 4, 9, 6, 0},
                         {0, 0, 6, 9, 0, 8, 4, 0, 0},
                         {0, 0, 0, 1, 5, 6, 0, 7, 0},
                         {9, 0, 0, 0, 0, 0, 0, 0, 0}};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println(" i is " + i + " j is " + j + " Saved is "+saved[i][j]);
                if (saved[i][j] == 0 ) {
                    int k = tableToSolve[i][j]+1;

                    while (k <= 9) {
                        // Parsing through possibilities and checking if table is solved.
                        if (checkIfValid(k, i, j, tableToSolve)) {

                            tableToSolve[i][j] = k;
                            showTable(tableToSolve);
                            if ((i == 8) && (j ==8)) return tableToSolve;

                            k = 10;
                        }

                        k++;

                    }
                    // After the while loop happened, there are two possibilities, k is 11 so a suitable answer was found and we must continue onto the next case.
                    // Or k is 10 so the algorithm went trough all possibilities but couldn't find any matches so we need to backtrack.
                    // Backtracking bit.
                    if ( k !=11 ) {
                        System.out.println("Need to backtrack");
                        tableToSolve[i][j]=0;
                        if (j > 0 ) {
                            j--;
                        }
                        else if(i>0) {i--;j=8;}
                        for (int p = i ;p>=0 ;p--){
                            for (int l = j; l>=0;l--) {
                                if (saved[p][l] == 0) {
                                    System.out.println("ok at " + p + " and " +l);
                                    i = p; j = l;
                                    p = -1; l=-1;
                                }
                            }
                        }
                        if (j <= 8) { j--;}
                        else {i--; j=7;}


                        /*
                        // Switch until we find the last null element.
                        int sw = 0;
                        while ((i>=0) && (sw ==0)) {
                            while ((j>=0)&&(sw == 0)){
                                j--;
                                // Using the saved table, we will parseback until we find the previous zero. I am using this instead of calling the function recursively as although it's more inefficient, it's harder to implement.
                                if (saved [i][j] == 0 ) { j = j -1; sw = 1; }
                                else j--;
                            }
                            j = 8;
                            if (saved [i-1][j] ==0 ) { i = i-1; sw = 1; }
                            else i--;
                        }
                        */
                    }
                }

            }}
        return null;
    }



    /**
     * Basic method that checks if the given input follows the rules of sudoku given the rules.
     * TODO: Extension to show what rule is broken in case of user playing.
     * @param valueToCheck the value to be checked
     * @param x the row of the value to be inserted
     * @param y the colloum of the value to be inserted
     * @param table the current sudoku table
     * @return true if it can be inserted there or false otherwise.
     */

    public boolean checkIfValid (int valueToCheck,int x, int y, int[][] table) {

        // Checking the row and the colloum;
        for (int i = 0; i<9; i++) {
            if ((table[x][i] == valueToCheck) || (table[i][y] == valueToCheck) ) {
                System.out.println("Value " + valueToCheck + " already present on line " + x + "or row "+y);
            return false; }
        }
        // Checking the square
        int xTable = x/3;
        xTable = xTable*3;
        int yTable = y/3;
        yTable = yTable*3;
        for (int i= xTable; i<=xTable+2; i++){
            for (int j= yTable; j<=yTable+2; j++) {
                //System.out.println ("table["+i+"]["+j+"] "+ table[i][j] +" == "+valueToCheck+"valueToCheck") ;
                if (table[i][j] == valueToCheck) {
                    System.out.println("Value already in the box");
                return false;}
            }
        }

    return true;
    }

    /**
     *  A method which prints in a semi-friendly format the output of a sudoku table.
     * @param tableToShow
     */

    public static void showTable (int[][] tableToShow) {

        for (int i = 0; i<=8; i++) {
           // if (i%3==0 ) System.out.println(" ------------------------------");
            for (int j=0; j<9; j++) {
                if (j%3==0 ) System.out.print("|");
                if (tableToShow[i][j] == 0) System.out.print( "[" + " " +"]");
                else System.out.print( "[" + tableToShow[i][j] +"]");


            }
            System.out.print("\n");


        }
        System.out.println(" ------------------------------");


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
