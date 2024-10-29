package xiangqi;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class XiangqiGame extends JPanel {

    private Piece selectedPiece = null;
    private CardLayout cardlayout;
    private JPanel cardpanel;
    User vsuser;
    User player1;

    public XiangqiGame(CardLayout cardlayout, JPanel cardpanel, User vsuser) {
        this.vsuser=vsuser;
        this.cardlayout = cardlayout;
        this.cardpanel = cardpanel;
        run();
    }

    boolean turn = true;
    Board b = new Board();
    Piece[][] gameboard = b.getBoard();
    JButton[][] buttonboard = new JButton[10][9];

    public void run() {
        setSize(800, 600);
        setLayout(new BorderLayout());
        
        

        JPanel dea = new JPanel();
        dea.setSize(300,600);
        dea.setBackground(Color.darkGray);
        
        //board
        JPanel board = new JPanel(new GridLayout(10, 9));
        board.setSize(600, 600);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                buttonboard[i][j] = new JButton();
                if ((i + j) % 2 == 0) {
                    buttonboard[i][j].setBackground(Color.DARK_GRAY);
                } else {
                    buttonboard[i][j].setBackground(Color.GRAY);
                }
                if (gameboard[i][j] != null) {
                    buttonboard[i][j].setIcon(gameboard[i][j].getImage());
                }
                buttonboard[i][j].setBorder(null);
                buttonboard[i][j].setFocusPainted(false);

                //ACTION LISTENER
                int row = i;
                int col = j;
                buttonboard[i][j].addActionListener(e -> Click(row, col));

                board.add(buttonboard[i][j]);

            }
        }

        add(board);
        
        
        
        
        add(board, BorderLayout.CENTER);
    }

    private void Click(int row, int col) {
        if (selectedPiece == null) {
            PieceSelection(row, col);
        } else {
            if (gameboard[row][col] != null && gameboard[row][col].color == selectedPiece.color) {
                updateBoard();
                PieceSelection(row, col);
            } else {
                movePiece(row, col);
            }
        }
    }

    public boolean PieceSelection(int row, int col) {
        if (gameboard[row][col] == null) {
            JOptionPane.showMessageDialog(null, "La Casilla esta Vacia");
            return false;
        } else {
            Piece piece = gameboard[row][col];
            if (piece.color == 'r' && turn == true) {
                selectedPiece = piece;
                showValid(row, col);

                buttonboard[row][col].setBackground(Color.YELLOW);
                return true;
            } else if (piece.color == 'b' && turn == false) {
                selectedPiece = piece;
                showValid(row, col);

                buttonboard[row][col].setBackground(Color.YELLOW);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No es su turno");
                return false;
            }
        }
    }

    public void movePiece(int row, int col) {
        if (selectedPiece.validMove(row, col, gameboard)) {
            int oldRow = selectedPiece.getRow();
            int oldCol = selectedPiece.getCol();

            gameboard[row][col] = selectedPiece;
            gameboard[oldRow][oldCol] = null;
            selectedPiece.setPiece(row, col);

            turn = !turn;
            selectedPiece = null;

            updateBoard();
        } else {
            JOptionPane.showMessageDialog(null, "Movimiento invalido");
        }
    }

    private void updateBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                buttonboard[i][j].setIcon(gameboard[i][j] != null ? gameboard[i][j].getImage() : null);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i + j) % 2 == 0) {
                    buttonboard[i][j].setBackground(Color.DARK_GRAY);
                } else {
                    buttonboard[i][j].setBackground(Color.GRAY);
                }
            }
        }
        repaint();
        revalidate();
        kingStatus();
    }

    private void showValid(int row, int col) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (selectedPiece.validMove(i, j, gameboard)) {
                    if (gameboard[i][j] != null && selectedPiece.color != gameboard[i][j].color) {
                        buttonboard[i][j].setBackground(Color.RED);
                    } else if (gameboard[i][j] == null) {
                        buttonboard[i][j].setBackground(Color.GREEN);
                    }
                }
            }
        }
    }

    private void kingStatus() {

        Piece rKing = null;
        Piece bKing = null;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                Piece piece = gameboard[i][j];
                if (piece != null && piece instanceof King) {
                    if (piece.getColor() == 'r') {
                        rKing = piece;
                    } else if (piece.getColor() == 'b') {
                        bKing = piece;
                    }
                }
            }
        }
        if (rKing == null) {
            JOptionPane.showMessageDialog(null, "El Rey Rojo ha sido capturado. ¡Ganan las piezas negras!");
            Users u=new Users();
            u.pointgiver(vsuser);
            Games log=new Games(u.getLoggedUser(),vsuser,true);
            Games log2=new Games(vsuser,u.getLoggedUser(),false);
            u.getLoggedUser().addlog(log2);
            vsuser.addlog(log);
            
            cardlayout.show(cardpanel, "menu");
        } else if (bKing == null) {
            JOptionPane.showMessageDialog(null, "El Rey Negro ha sido capturado. ¡Ganan las piezas rojas!");
            Users u=new Users();
            u.pointgiver(u.getLoggedUser());
            Games log=new Games(u.getLoggedUser(),vsuser,false);
            Games log2=new Games(vsuser,u.getLoggedUser(),true);
            u.getLoggedUser().addlog(log);
            vsuser.addlog(log2);
            
            cardlayout.show(cardpanel, "menu");
        }
    }

}


//Yo soy el Jefe!
