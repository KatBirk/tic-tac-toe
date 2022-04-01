package CLI_version;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for (int i = 0; i<3;i++){
            for (int j = 0; j<3;j++){
                board[i][j] = '-';
            }
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of player 1: ");
        String p1 = scanner.nextLine();
        System.out.println("Enter name of player 2: ");
        String p2 = scanner.nextLine();

        printBoard(board);

    }

    public static void printBoard(char[][] board){
        for (int i = 0; i<3;i++){
            for (int j = 0; j<3;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
