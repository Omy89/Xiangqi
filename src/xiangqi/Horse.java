package xiangqi;

import javax.swing.ImageIcon;

public class Horse extends Piece {

    ImageIcon image;

    public Horse(int row, int col, char color) {
        super(row, col, color);
        if (color == 'b') {
            image = new ImageIcon(getClass().getResource("/images/Bhorse.png"));
        } else {
            image = new ImageIcon(getClass().getResource("/images/Rhorse.png"));
        }
    }

    public ImageIcon getImage() {
        return image;
    }

    @Override
    public boolean validMove(int newrow, int newcol, Piece[][] board) {
        int rowDiff = newrow - row;
        int colDiff = newcol - col;

        if ((rowDiff == 2 && (colDiff == 1 || colDiff == -1) && board[row + 1][col] == null)
                || (rowDiff == -2 && (colDiff == 1 || colDiff == -1) && board[row - 1][col] == null)
                || (colDiff == 2 && (rowDiff == 1 || rowDiff == -1) && board[row][col + 1] == null)
                || (colDiff == -2 && (rowDiff == 1 || rowDiff == -1) && board[row][col - 1] == null)) {
            return true;
        }
        return false;
    }

    
    /*
    chites de ernesto
    
    "¿Sabías que el wifi es como el romance? Si no tienes la clave, te quedas mirando desde lejos."

    "Dicen que el desayuno es la comida más importante del día, pero no te preocupes, yo puedo esperar a la cena."

    "Cuando alguien me dice que no puede vivir sin mí, pienso: 'Tranquilo, eso también lo decías de tu ex'."

    "Soy como el café: caliente, fuerte, y probablemente te mantenga despierto toda la noche."

    "Dicen que uno nunca olvida su primera vez... Y yo sigo acordándome de esa primera vez que no respondí un mensaje a tiempo."
    
    "Me dijeron que te acercaras a lo que te hace feliz... Así que ya estoy aquí. ¿Cuándo empezamos?"
    
    "Si los ojos son las ventanas del alma... espero que los míos te hayan dado alguna pista de que no quiero sólo hablar."
    
    "Le pedí un consejo a una amiga y me dijo: 'Ve despacio, sin prisa'. Lo tomé en serio… y llegué tarde al trabajo."
    
    "Cuando me miras así, siento que estás a punto de decir: '¿Cómo te gusta el café?'"
    
    "Le dijeron que todo lo bueno se toma con calma. Pero él… parece que lo olvidó anoche."
     */
}
