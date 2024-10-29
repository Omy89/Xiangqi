/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xiangqi;

import javax.swing.ImageIcon;

/**
 *
 * @author OMy
 */
public class King extends Piece {

    public King(int row, int col, char color) {
        super(row, col, color);
        if (color == 'b') {
            image = new ImageIcon(getClass().getResource("/images/Bking.png"));
        } else {
            image = new ImageIcon(getClass().getResource("/images/Rking.png"));
        }
    }

    @Override
    public boolean validMove(int newrow, int newcol, Piece[][] board) {
        int rowDiff = newrow - row;
        int colDiff = newcol - col;

        if ((rowDiff == 0 && (colDiff == 1 || colDiff == -1)) || (colDiff == 0 && (rowDiff == 1 || rowDiff == -1))) {
            if (color == 'b' && newrow >= 0 && newrow <= 2 && newcol >= 3 && newcol <= 5) {
                return true;
            } else if (color == 'r' && newrow >= 7 && newrow <= 9 && newcol >= 3 && newcol <= 5) {
                return true;
            }
        }
        return false;
    }
}
