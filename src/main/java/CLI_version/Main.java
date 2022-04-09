package CLI_version;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Creating 2d char array and filling with -
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        Scanner scanner = new Scanner(System.in);

        boolean player1Turn = true;
        boolean gameFinished = false;

        while (!gameFinished) {
            printBoard(board);

            //Board position variables (indexes)
            int row;
            int column;

            //Determine who goes next
            if (player1Turn){
                System.out.println("Player 1's turn (x)");
            } else {
                System.out.println("Player 2's turn (o)");
            }

            //Setting symbol for players
            char symbol = '-';
            if (player1Turn) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }

            //Let player make move and check if a valid position is entered
            while (true){
                System.out.println("Please enter a number between 1 and 9: ");
                int[] num = numberToPosition(scanner.nextInt());
                row = num[0];
                column = num[1];

                if (row == -1){
                    System.out.println("This position is invalid! Try entering a number between 1 and 9");
                } else if (board[row][column] != '-'){
                    System.out.println("This position is occupied, try again!");
                } else {
                    break;
                }
            }

            //Place correct symbol on board at chosen position
            board[row][column] = symbol;

            //Check if game has been won!
            if (checkWinner(board) == 'x'){
                System.out.println("Player 1 has won!");
                gameFinished = true;
            } else if (checkWinner(board) == 'o'){
                System.out.println("Player 2 has won!");
                gameFinished = true;
            } else {
                if (checkBoardFull(board)){
                    System.out.println("The board is full. Ending the game...");
                    gameFinished = true;

                } else {
                    //change turn
                    player1Turn = !player1Turn;
                }
            }
        }
        printBoard(board);

    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[] numberToPosition(int number) {
        int[] pos = new int[2];
        switch (number) {
            case 1:
                pos[0] = 0;
                pos[1] = 0;
                return pos;
            case 2:
                pos[0] = 0;
                pos[1] = 1;
                return pos;
            case 3:
                pos[0] = 0;
                pos[1] = 2;
                return pos;
            case 4:
                pos[0] = 1;
                pos[1] = 0;
                return pos;
            case 5:
                pos[0] = 1;
                pos[1] = 1;
                return pos;
            case 6:
                pos[0] = 1;
                pos[1] = 2;
                return pos;
            case 7:
                pos[0] = 2;
                pos[1] = 0;
                return pos;
            case 8:
                pos[0] = 2;
                pos[1] = 1;
                return pos;
            case 9:
                pos[0] = 2;
                pos[1] = 2;
                return pos;
            default:
                pos[0] = -1;
                return pos;
        }
    }

    public static char checkWinner(char[][] board) {

        //Check rows
        for (int i = 0; i<3; i++){
            if (board[0][i] != '-' && board[i][0]==board[i][2] && board[i][2]==board[i][1]){
                return board[i][0];
            }
        }

        //Check columns
        for (int j = 0; j<3;j++){
            if (board[0][j] != '-' && board[0][j]==board[2][j] && board[2][j]==board[1][j]){
                return board[0][j];
            }
        }

        if (board[0][0] == board[1][1] && board[0][0] ==board[2][2] && board[0][0]!='-'
                || board[0][2] == board[1][1] && board[0][2] ==board[2][0] && board[0][2]!='-'){
            return board[1][1];
        }


        //No winner yet
        return ' ';
    }

    public static boolean checkBoardFull(char[][] board){
        //Implement method
        for (int i = 0; i < 3; i++){
            for (int j=0; j<3;j++){
                if (board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
}
