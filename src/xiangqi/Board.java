package xiangqi;

public class Board {

    private Piece[][] board;

    public Board() {
        newGame();
    }

    public void newGame() {
        board = new Piece[10][9];
        //negras
        
        board[0][0] = new Rook(0, 0, 'b');
        board[0][8] = new Rook(0, 8, 'b');
        board[0][3] = new Advisor(0, 3, 'b');
        board[0][5] = new Advisor(0, 5, 'b');
        board[0][4] = new King(0, 4, 'b');
        board[0][2] = new Elephant(0, 2, 'b');
        board[0][6] = new Elephant(0, 6, 'b');
        board[0][1] = new Horse(0, 1, 'b');
        board[0][7] = new Horse(0, 7, 'b');
        
        board[2][1] = new Cannon(2, 1, 'b');
        board[2][7] = new Cannon(2, 7, 'b');

        board[3][0] = new Soldier(3, 0, 'b');
        board[3][2] = new Soldier(3, 2, 'b');
        board[3][4] = new Soldier(3, 4, 'b');
        board[3][6] = new Soldier(3, 6, 'b');
        board[3][8] = new Soldier(3, 8, 'b');
        //rojas
        board[9][0] = new Rook(9, 0, 'r');
        board[9][8] = new Rook(9, 8, 'r');
        board[9][5] = new Advisor(9, 5, 'r');
        board[9][3] = new Advisor(9, 3, 'r');
        board[9][4] = new King(9, 4, 'r');
        board[9][2] = new Elephant(9, 2, 'r');
        board[9][6] = new Elephant(9, 6, 'r');
        board[9][1] = new Horse(9, 1, 'r');
        board[9][7] = new Horse(9, 7, 'r');
        
        board[7][1] = new Cannon(7, 1, 'r');
        board[7][7] = new Cannon(7, 7, 'r');

        board[6][0] = new Soldier(6, 0, 'r');
        board[6][2] = new Soldier(6, 2, 'r');
        board[6][4] = new Soldier(6, 4, 'r');
        board[6][6] = new Soldier(6, 6, 'r');
        board[6][8] = new Soldier(6, 8, 'r');

       
    }

    public Piece[][] getBoard() {
        return board;
    }

}
