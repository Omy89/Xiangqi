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
public class Rook extends Piece {

    public Rook(int row, int col, char color) {
        super(row, col, color);
        if (color == 'b') {
            image = new ImageIcon(getClass().getResource("/images/Brook.png"));
        } else {
            image = new ImageIcon(getClass().getResource("/images/Rrook.png"));
        }
    }

    @Override
    public boolean validMove(int newrow, int newcol, Piece[][] board) {
        if (row == newrow) {
            int step = col < newcol ? 1 : -1;
            for (int i = col + step; i != newcol && i >= 0 && i < 9; i += step) {
                if (board[row][i] != null) {
                    return false;
                }
            }
            return true;
        } else if (col == newcol) {
            int step = row < newrow ? 1 : -1;
            for (int i = row + step; i != newrow && i >= 0 && i < 10; i += step) {
                if (board[i][col] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
