package xiangqi;

import javax.swing.ImageIcon;

public class Advisor extends Piece {

    public Advisor(int row, int col, char color) {
        super(row, col, color);
        if (color == 'b') {
            image = new ImageIcon(getClass().getResource("/images/Badvisor.png"));
        } else {
            image = new ImageIcon(getClass().getResource("/images/Radvisor.png"));
        }
    }

    @Override
    public boolean validMove(int newrow, int newcol, Piece[][] board) {
        int rowDiff = newrow - row;
        int colDiff = newcol - col;

        if ((rowDiff == 1 || rowDiff == -1) && (colDiff == 1 || colDiff == -1)) {
            if (color == 'b' && newrow >= 0 && newrow <= 2 && newcol >= 3 && newcol <= 5) {
                return true;
            } else if (color == 'r' && newrow >= 7 && newrow <= 9 && newcol >= 3 && newcol <= 5) {
                return true;
            }
        }
        return false;
    }
}
