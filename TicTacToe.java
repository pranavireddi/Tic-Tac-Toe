import java.util.Random;
import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};
        printBoard(board);

        Scanner scanner = new Scanner(System.in);

        while(true){
            playerMove(board, scanner);
            if(isGameFinished(board)){
                break;
            }
            computerTurn(board);
    
            printBoard(board);
        }



        //printBoard(board);
    }

    //checks for 3-in-a-row
    private static boolean hasContestantWon(char[][]board, char symbol){
     if((board[0][0] == symbol || board[0][1] == symbol|| board[0][2] == symbol)||
        (board[1][0]== symbol || board[1][1] == symbol|| board[1][2] == symbol)||
        (board[2][0]== symbol || board[2][1]== symbol || board[2][2]== symbol) ||

        (board[0][0] == symbol || board[1][0] == symbol|| board[2][0] == symbol)||
        (board[0][1]== symbol || board[1][1] == symbol|| board[2][1] == symbol)||
        (board[0][2]== symbol || board[1][2]== symbol || board[2][2]== symbol) ||
        
        (board[0][0] == symbol || board[1][1] == symbol|| board[2][2] == symbol)||
        (board[0][2]== symbol || board[1][1] == symbol|| board[2][0] == symbol))
        {
             
            return true;
        }

       boolean falso = false;
       return falso;
    }

//checks if the game has ended
    private static boolean isGameFinished(char[][] board) {

        if( hasContestantWon(board, 'X')){
            System.out.println("Player wins!");
            return true;
        }

        if( hasContestantWon(board, 'O')){
            System.out.println("Computer wins!");
            return true;
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return false;

    }

    //helps computer make its move
    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        

        while(true){
            computerMove = rand.nextInt(9) + 1;
            if(isValidMove(board, computerMove)){
                break;
            }
        }
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    //checks if given move is even allowed
    private static boolean isValidMove (char[][]board, int position){
        switch(position){
            case 1:
            return(board[0][0] == ' ');

            case 2:
            return(board[0][1] == ' ');

            case 3:
            return(board[0][2] == ' ');

            case 4:
            return(board[1][0] == ' ');

            case 5:
            return(board[1][1] == ' ');

            case 6:
            return(board[1][2] == ' ');

            case 7:
            return(board[2][0] == ' ');

            case 8:
            return(board[2][1] == ' ');

            case 9:
            return(board[2][2] == ' ');

            default:
            return false;
        }
    }

    //helps player make move
    private static void playerMove(char[][] board, Scanner scanner) {
        String userInput;
        while(true){
        System.out.println("Where would you like to place your move? (Options: 1- 9)");
        userInput = scanner.nextLine();
        if(isValidMove(board, Integer.parseInt(userInput))){
            break;
        }
        else{
            System.out.println(userInput + " is not a valid move.");
        }
        placeMove(board, userInput, 'X');
        scanner.close();
        }
    }

    //adds move to board
    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position){
            case "1":
            board[0][0] = symbol;
            break;

            case "2":
            board[0][1] = symbol;
            break;

            case "3":
            board[0][2] = symbol;
            break;

            case "4":
            board[1][0] = symbol;
            break;

            case "5":
            board[1][1] = symbol;
            break;

            case "6":
            board[1][2] = symbol;
            break;

            case "7":
            board[2][0] = symbol;
            break;

            case "8":
            board[2][1] = symbol;
            break;

            case "9":
            board[2][2] = symbol;
            break;

            default:
            System.out.println("not valid");
        }
    }

    //prints board
    private static void printBoard(char[][] board){
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-*-*-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-*-*-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }


}