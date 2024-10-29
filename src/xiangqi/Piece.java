package xiangqi;

import javax.swing.ImageIcon;

public abstract class Piece {
    protected int row;
    protected int col;
    protected char color;
    protected ImageIcon image;
    
    public Piece(int row, int col, char color){
        this.row=row;
        this.col=col;
        this.color=color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getColor() {
        return color;
    }
    
    public void setPiece(int row, int col){
        this.row=row;
        this.col=col;
    }

    public ImageIcon getImage() {
        return image;
    }
    
    public abstract boolean validMove(int newrow, int newcol, Piece[][] board);
    
}
