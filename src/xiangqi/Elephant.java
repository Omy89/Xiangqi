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
public class Elephant extends Piece {

    public Elephant(int row, int col, char color) {
        super(row, col, color);
        if (color == 'b') {
            image = new ImageIcon(getClass().getResource("/images/Belephant.png"));
        } else {
            image = new ImageIcon(getClass().getResource("/images/Relephant.png"));
        }
    }

    @Override
    public boolean validMove(int newrow, int newcol, Piece[][] board) {
        int rowDiff = newrow - row;
        int colDiff = newcol - col;

        if ((rowDiff == 2 || rowDiff == -2) && (colDiff == 2 || colDiff == -2)) {
            if (color == 'b' && newrow >= 0 && newrow <= 4) {
                return true;
            } else if (color == 'r' && newrow >= 5 && newrow <= 9) {
                return true;
            }
        }
        return false;
    }
}
