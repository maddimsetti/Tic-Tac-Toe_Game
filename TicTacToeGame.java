package tictactoe;

import java.util.Scanner;

/**
 * @description create Class for defining the TicTacToeGame
 * @param None
 * 
 */
public class TicTacToeGame {
	static String[] board = new String[10];
	static String turn;

	/**
	 * @description Private Method to initializing TicTacToeBoard and set the board
	 *              to all empty values
	 * @param None
	 * 
	 */
	private void IntializingBoard() {
		for (int a = 0; a < 9; a++) { // for loop to initializing board
			board[a] = String.valueOf(a + 1); // values stores in array string
		}
	}

	/**
	 * @description Method to create for choosing Player option
	 * @param None
	 * 
	 */
	private void chooseYourOption() {
		System.out.println("Choose the Option X or O");
		Scanner sc = new Scanner(System.in);
		String player = sc.nextLine();
		sc.close();
		if (player.equals("X")) { // player choose X option
			player = "X";
			turn = "O";
		} else if (player.equals("O")) { // player Choose O option
			player = "O";
			turn = "X";
		} else
			System.out.println("Invalid Input");
	}

	/**
	 * @description Method to Create Print Board
	 * @param None
	 * 
	 */
	private void printBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}

	/**
	 * @description Method to Create Current Board
	 * @param None
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Tic-Tac-Toe Game");
		TicTacToeGame tictactoegame = new TicTacToeGame();// Create Object related to Class
		tictactoegame.IntializingBoard();// relation between Main and InitializingBoard Method
		tictactoegame.chooseYourOption();// relation between Main and Player Option
		tictactoegame.printBoard();
	}

}
