package tictactoe;

import java.util.Scanner;

/**
 * @description create Class for defining the TicTacToeGame
 * @param None
 * 
 */
public class TicTacToeGame {
	private static String[] board = new String[10];
	private static String computer;
	private String player;
	private static final Scanner sc = new Scanner(System.in);

	/**
	 * @description Private Method to initializing TicTacToeBoard and set the board
	 *              to all empty values
	 * @param None
	 * 
	 */
	private void IntializingBoard() {
		for (int a = 1; a < 10; a++) { // for loop to initializing board
			board[a] = String.valueOf(a); // values stores in array string
		}
	}

	/**
	 * @description Method to create for choosing Player option
	 * @param Choose the player as option X or O
	 * 
	 */
	private void chooseYourOption() {
		boolean validOption = false; // input validation
		do {
			System.out.println("Choose the Option X or O");
			String option = sc.nextLine();
			if (option.equals("X")) { // player choose X option
				player = "X";
				computer = "O";
				validOption = true;
			} else if (option.equals("O")) { // player Choose O option
				player = "O";
				computer = "X";
				validOption = true;
			} else {
				System.out.println("Invalid Option");
			}
		} while (!validOption); // repeat until input valid
	}

	/**
	 * @description Method to Create Print Board
	 * @param None
	 * 
	 */
	private void printBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
		System.out.println("|---|---|---|");
	}

	/**
	 * @description Method to Create for user to make a move to a desired location
	 *              in the board
	 * @param Input will take input from user like from 1 to 9. If it is not in
	 *              range from 1 to 9. Then it will show you an error "Invalid
	 *              input."
	 * 
	 */
	private void desiredLocation() {
		boolean validInput = false; // input validation
		do {
			System.out.println("Enter the Choice");
			int input = sc.nextInt();
			if (input > 0 && input < 10) {
				board[input] = player;
				printBoard();
				validInput = true;
			} else
				System.out.println("Invalid input; re-enter slot number:");
		} while (!validInput); // repeat until input is valid
	}

	// Explanation How to implement the Computation
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Tic-Tac-Toe Game");
		TicTacToeGame tictactoegame = new TicTacToeGame();// Create Object related to Class
		tictactoegame.IntializingBoard();// relation between Main and InitializingBoard Method
		tictactoegame.chooseYourOption();// relation between Main and Player Option
		tictactoegame.printBoard(); // relation between Main and PrintBoard
		tictactoegame.desiredLocation(); //relation between Main and Location to move
	}

}
