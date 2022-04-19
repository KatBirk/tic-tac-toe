package GUI_version;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;

public class PrimaryController {
    //todo: change labels to buttons (and disable)

    @FXML
    private GridPane grid;
    @FXML
    private Label message, label1, label2,
            label3, label4, label5, label6,
            label7, label8, label9;
    private Label[][] tiles = {{label1, label2, label3}, {label4, label5, label6}, {label7, label8, label9}};

    boolean player1Turn = true;
    boolean gameFinished = false;
    private String symbol = "x";


    @FXML
    public void onTileClick(ActionEvent ev) {
        turnActions();
        if (checkWinner(tiles) == null) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (ev.getSource().equals(tiles[row][col])) {
                        if (tiles[row][col].getText() == null) {
                            tiles[row][col].setText(symbol);
                            break;
                        } else {
                            message.setText("Can't pick that tile");
                        }
                    }
                }
            }
            player1Turn = !player1Turn;
            turnActions();
        } else {
            message.setText("Winner: "+checkWinner(tiles));
        }
    }

    @FXML
    public void onStartButtonClick() {
        grid.setDisable(false);
        grid.setOpacity(1);
        turnActions();
    }

    public void turnActions() {
        if (player1Turn) {
            message.setText("Player 1's turn");
            symbol = "x";
        } else {
            message.setText("Player 2's turn");
            symbol = "o";
        }
    }

    public static String checkWinner(Label[][] board) {
        //Check rows
        for (int i = 0; i < 3; i++) {
            if (!board[0][i].getText().isEmpty() && board[i][0].getText() == board[i][2].getText() && board[i][2].getText() == board[i][1].getText()) {
                return board[i][0].getText();
            }
        }

        //Check columns
        for (int j = 0; j < 3; j++) {
            if (!board[0][j].getText().isEmpty() && board[0][j].getText() == board[2][j].getText() && board[2][j].getText() == board[1][j].getText()) {
                return board[0][j].getText();
            }
        }

        if (board[0][0].getText() == board[1][1].getText() && board[0][0].getText() == board[2][2].getText() && !board[0][0].getText().isEmpty()
                || board[0][2].getText() == board[1][1].getText() && board[0][2].getText() == board[2][0].getText() && !board[0][2].getText().isEmpty()) {
            return board[1][1].getText();
        }

        //CheckStalemate
        if (checkStalemate(board)==true){
            return "none.";
        }

        //No winner yet
        return null;
    }

    public static boolean checkStalemate(Label[][] board){
        for (int i = 0; i < 3; i++){
            for (int j=0; j<3;j++){
                if (board[i][j].getText() == null){
                    return false;
                }
            }
        } return true;
    }
}