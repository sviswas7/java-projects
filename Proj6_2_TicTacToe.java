import java.util.Scanner;
public class Proj6_2_TicTacToe {
    public static void main(String[] args)
    {


        runGame();
    }//end main

    public static void runGame() {
        String winner = "";
        int ROWS = 3;
        int COLS = 3;
        boolean xTurn = true;
        String[][] gameBoard = new String[ROWS][COLS];
        initialiseGameBoard(gameBoard);
        printCurrentBoard(gameBoard);
        //        getWinner(gameBoard);

        Scanner keyboard = new Scanner(System.in);

        int row = 0;
        int col = 0;

        while (winner.equals("")) {
            if (xTurn)
            {
                System.out.println("It's X's turn!");
            } else {
                System.out.println("It's O's turn!");
            }

            getUserInput(xTurn, gameBoard);
            winner = getWinner(gameBoard);
            printCurrentBoard(gameBoard);
            System.out.println();

            xTurn = !xTurn;

            if (winner.equals("") && isBoardFull(gameBoard)) {
                winner = "C";
            }
        }

        System.out.println();
        if(winner.equals("C"))
        {
            System.out.println("It was the Cat's game! NO WINNER!");
        }
        else {
            System.out.println("The winner " + winner);
        }

    }//end runGame

    public static void initialiseGameBoard(String[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = " ";
            }
        }//end outer
    }//end initialiseGameBoard

    public static void printCurrentBoard(String[][] gameBoard) {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }//end inner for
            System.out.println();
            if (i < 2) {
                System.out.print("_ _ _ _ _");
            }

            System.out.println();
        }//end outer
    }//end printCurrentGame Board


    public static void getUserInput(boolean xTurn, String[][] gameBoard) {
        Scanner keyboard = new Scanner(System.in);

        int row = -1;
        int col = -1;
        boolean keepAsking = true;
        while(keepAsking)
        {
            System.out.println("Please enter the row THEN "
                    + " the column, each from 0, 1, or 2"
                    + "separated by a space");

            row = keyboard.nextInt();
            col = keyboard.nextInt();

            if(row>= 0 && row <= 2 &&
            col >=0 && col <=2) {
                if (!cellAlreadyOccupied(row, col, gameBoard)) {
                    keepAsking = false;
                } else {
                    System.out.println("That cell is already occupied");
                }
            }

        }

        if(xTurn)
        {
            gameBoard[row][col] = "X";
        }
        else
        {
            gameBoard[row][col] = "O";
        }

    }//end getUserInput

    public static boolean cellAlreadyOccupied(int row, int col, String[][] gameBoard) {
        return !gameBoard[row][col].equals(" ");
    }

    public static boolean isBoardFull(String[][] gameBoard) {
        int countFill = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j].equals(" ")) {
                    countFill++;
                }
            }
        }
        return countFill == 9;
    }// end isBoardFull


    public static String getWinner(String[][] gameBoard) {
        final int ROWS = gameBoard.length;
        final int COLS = gameBoard[0].length;

        for (int i = 0; i < ROWS; i++) {
            if (!gameBoard[i][0].equals(" ") && gameBoard[i][0].equals(gameBoard[i][1]) && gameBoard[i][1].equals(gameBoard[i][2])) {
                return gameBoard[i][0]; // we have a match (horizontal)
            }

        }

        for (int i = 0; i < COLS; i++) {
            if (!gameBoard[0][i].equals(" ") && gameBoard[0][i].equals(gameBoard[1][i]) && gameBoard[1][i].equals(gameBoard[2][i])) {
                return gameBoard[0][i]; // we have a match (vertical)
            }

        }

        if (!gameBoard[0][0].equals(" ") && gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
            return gameBoard[0][0]; // we have a match (vertical)
        }

        if (!gameBoard[2][0].equals(" ") && gameBoard[2][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[0][2])) {
            return gameBoard[2][0]; // we have a match (vertical)
        }
        return "";
    }
}
