package rocks.zipcode.io.quiz3.arrays;

import java.util.Arrays;

/**
 * @author leon on 09/12/2018.
 */
public class TicTacToe {
    String[][] board;

    public TicTacToe(String[][] board) {
        this.board = board;
    }

    public TicTacToe() {
    }

    public String[] getRow(Integer value) {
        return board[value];
    }

    public String[] getColumn(Integer value) {
        String[] column = new String[3];
        for (int i = 0; i < 3; i++) {
            column[i] = board[i][value];
        }
        return column;
    }

    public Boolean isRowHomogenous(Integer rowIndex) {
        Boolean result = true;
        String[] row = getRow(rowIndex);
        for (int i = 1; i < row.length; i++) {
            if (row[0] != row[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public Boolean isColumnHomogeneous(Integer columnIndex) {
        Boolean result = true;
        String[] column = getColumn(columnIndex);
        for (int i = 1; i < column.length; i++) {
            if (column[0] != column[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public Boolean isInFavorOfO() {
        if (board[0][0].equals("O") && isColumnHomogeneous(0)) return true;
        else if (board[0][1].equals("O") && isColumnHomogeneous(1)) return true;
        else if (board[0][2].equals("O") && isColumnHomogeneous(1)) return true;
        else if (board[0][0].equals("O") && isRowHomogenous(0)) return true;
        else if (board[1][0].equals("O") && isRowHomogenous(1)) return true;
        else if (board[2][0].equals("O") && isRowHomogenous(2)) return true;
        else if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) return true;
        else if (board[2][0].equals("O") && board[1][1].equals("O") && board[0][2].equals("O")) return true;
        else return false;
    }
    public Boolean isInFavorOfX() {
        if (board[0][0].equals("X") && isColumnHomogeneous(0)) return true;
        else if (board[0][1].equals("X") && isColumnHomogeneous(1)) return true;
        else if (board[0][2].equals("X") && isColumnHomogeneous(1)) return true;
        else if (board[0][0].equals("X") && isRowHomogenous(0)) return true;
        else if (board[1][0].equals("X") && isRowHomogenous(1)) return true;
        else if (board[2][0].equals("X") && isRowHomogenous(2)) return true;
        else if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) return true;
        else if (board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals("X")) return true;
        else return false;
    }

    public String getWinner() {
        if (isInFavorOfO()) return "O";
        else if (isInFavorOfX()) return "X";
        else return "Tie";
    }

    public String[][] getBoard() {
        return board;
    }
}
