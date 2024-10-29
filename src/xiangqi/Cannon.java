package xiangqi;

import javax.swing.ImageIcon;

public class Cannon extends Piece {

    public Cannon(int row, int col, char color) {
        super(row, col, color);
        if (color == 'b') {
            image = new ImageIcon(getClass().getResource("/images/Bcannon.png"));
        } else {
            image = new ImageIcon(getClass().getResource("/images/Rcannon.png"));
        }
    }

    @Override
        

    public boolean validMove(int newrow, int newcol, Piece[][] board) {
        if (newrow < 0 || newrow >= 10 || newcol < 0 || newcol >= 9) {
            return false;
        }

        int rowDiff = newrow - row;
        int colDiff = newcol - col;

        if (rowDiff == 0) {
            int step = colDiff > 0 ? 1 : -1;
            int stones = 0;

            for (int i = col + step; i != newcol && i >= 0 && i < 9; i += step) {
                if (board[row][i] != null) {
                    stones++;
                }
            }

            if (board[newrow][newcol] == null && stones == 0) {
                return true;
            }

            if (board[newrow][newcol] != null && stones == 1 && board[newrow][newcol].color != this.color) {
                return true;
            }
        } else if (colDiff == 0) {
            int step = rowDiff > 0 ? 1 : -1;
            int stones = 0;

            for (int i = row + step; i != newrow && i >= 0 && i < 10; i += step) {
                if (board[i][col] != null) {
                    stones++;
                }
            }

            if (board[newrow][newcol] == null && stones == 0) {
                return true;
            }

            if (board[newrow][newcol] != null && stones == 1 && board[newrow][newcol].color != this.color) {
                return true;
            }
        }

        return false;
    }
}
