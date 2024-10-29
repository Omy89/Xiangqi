package xiangqi;

import javax.swing.ImageIcon;

public class Soldier extends Piece {

    ImageIcon image;

    public Soldier(int row, int col, char color) {
        super(row, col, color);
        if (color == 'b') {
            image = new ImageIcon(getClass().getResource("/images/Bsoldier.png"));
        } else {
            image = new ImageIcon(getClass().getResource("/images/Rsoldier.png"));
        }
    }

    public ImageIcon getImage() {
        return image;
    }
    
    public boolean validMove(int newrow, int newcol, Piece[][] board){
        if(color=='r'){
            if(row>=5){
                if(col==newcol && newrow==(row-1)){
                    return true;
                }
            } else if(row<5){
                if((newrow==(row-1) && newcol==col)|| (newcol==(col-1) && newrow==row)|| (newcol==(col+1)&& newrow==row)){
                    return true;
                }
            }
        } else {
            if(row<=4){
                if(col==newcol && newrow==(row+1)){
                    return true;
                }
            } else if(row>4){
                 if((newrow==(row+1) && newcol==col)|| (newcol==(col+1) && newrow==row)|| (newcol==(col-1)&& newrow==row)){
                    return true;
                }
            }
        }
        return false;
    }
    

}
