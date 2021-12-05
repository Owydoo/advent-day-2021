package day4.exo1;

import java.util.List;

import static utils.ArrayUtils.intIsInList;

public class BingoBoard {

    private int[][] board;

    public BingoBoard(int[][] board) {
        this.board = board;
    }

    public BingoBoard() {
        this.board = initBoard();
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[][] initBoard() {
        int[][] res = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                res[i][j] = 0;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String line1 = String.format("  %2d %2d %2d %2d %2d \n", board[0][0], board[0][1], board[0][2], board[0][3],
                board[0][4]);
        String line2 = String.format("  %2d %2d %2d %2d %2d \n", board[1][0], board[1][1], board[1][2], board[1][3],
                board[1][4]);
        String line3 = String.format("  %2d %2d %2d %2d %2d \n", board[2][0], board[2][1], board[2][2], board[2][3],
                board[2][4]);
        String line4 = String.format("  %2d %2d %2d %2d %2d \n", board[3][0], board[3][1], board[3][2], board[3][3],
                board[3][4]);
        String line5 = String.format("  %2d %2d %2d %2d %2d \n", board[4][0], board[4][1], board[4][2], board[4][3],
                board[4][4]);
        return "Board :\n"
                .concat(line1)
                .concat(line2)
                .concat(line3)
                .concat(line4)
                .concat(line5);
    }

    public boolean isWon(List<Integer> readInputs) {
        //vérifier pour une ligne si toutes les valeurs sont les inputs
        //Sinon passer à la ligne suivante.
        for (int line = 0; line < 5; line++) {
            if (lineIsCompleted(this.board[line], readInputs)) {
                System.out.println(String.format("line is completed\nreadInputs : %s",
                        readInputs.toString()));
                System.out.println(String.format("this.board[line] : %d %d %d %d %d", this.board[line][0],
                        this.board[line][1],this.board[line][2],this.board[line][3],this.board[line][4]));
                return true;
            }
        }
        for (int column = 0; column < 5; column++) {
            if (columnIsCompleted(this.board, column, readInputs)) {
                System.out.println(String.format("column is completed\ncolumn : %d, readInputs : %s",
                         column, readInputs.toString()));
                System.out.println(String.format("column : %d %d %d %d %d",this.board[0][column],
                        this.board[1][column],this.board[2][column],this.board[3][column],this.board[4][column]));
                return true;
            }
        }
        return false;
    }

    private boolean columnIsCompleted(int[][] board, int column, List<Integer> readInputs) {
        for (int line = 0; line < 5; line++) {
            //System.out.println("readinput : "+readInputs.contains(board[line][column]));
            if (!readInputs.contains(board[line][column])) {
                return false;
            }
        }
        return true;
    }

    private boolean lineIsCompleted(int[] ints, List<Integer> readInputs) {
        for (int i = 0; i < ints.length; i++) {
            if (!intIsInList(ints[i], readInputs)){
                return false;
            }
        }
        return true;
    }

}


