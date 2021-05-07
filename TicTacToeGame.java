package tictactoe;

import java.util.Arrays;
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
	private String turn;
	private static final Scanner sc = new Scanner(System.in);

	/**
	 * @description Private Method to initializing TicTacToeBoard and set the board
	 *              to all empty values
	 * @param None
	 * 
	 */
	private void IntializingBoard() {
		for (int square = 1; square < 10; square++) { // for loop to initializing board
			board[square] = String.valueOf(square); // values stores in array string
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
	 *              in the board. 1.Input will take input from user like from 1 to
	 *              9. If it is not in range from 1 to 9. Then it will show you an
	 *              error "Invalid input." 2.Check if the free space is available
	 *              for the move.In case available make move to desired location
	 * @param None
	 */
	private void moveToDesiredLocation() {
		boolean validInput = false; // input validation
		do {
			System.out.println("Enter the Input");
			int input = sc.nextInt();
			if (input > 0 && input < 10) {
				if (board[input] == "X" || board[input] == "O") { // Checking free space available or not
					System.out.println("The Position is Occupied,Kindly Select another Input");
					validInput = false; // repeat until free space available
				}
				board[input] = turn;
				printBoard(); // updating the game-Board content
				validInput = true; // input valid,exit the loop
			} else
				System.out.println("Invalid input; re-enter slot number:");
		} while (!validInput); // repeat until input is valid
	}

	/**
	 * @description Method to Create to flip a coin who plays first select either 0
	 *              for Tail or 1 for Head
	 * @param None
	 * 
	 */
	private void tossToCheckWhoFirst() {
		System.out.println("Select 0 for Tail or 1 for Head to see who plays first");
		int playerSelection = sc.nextInt(); // player selecting the option either 0 or 1
		int toss = (int) Math.floor(Math.random() * 10) % 2;
		if (playerSelection == toss) {
			System.out.println("Player Won the Toss and Plays First");
			turn = player;
		} else {
			System.out.println("Computer Won the Toss and Plays First");
			turn = computer;
		}
	}

	/**
	 * @description Method to create to check winner by decide the Combination of
	 *              three boxes given below
	 * @param None
	 * 
	 */
	private String checkWinner() {
		for (int square = 1; square < 9; square++) {
			String line = null;
			switch (square) {
			case 0:
				line = board[1] + board[2] + board[3];
				break;
			case 1:
				line = board[4] + board[5] + board[6];
				break;
			case 2:
				line = board[7] + board[8] + board[9];
				break;
			case 3:
				line = board[1] + board[4] + board[7];
				break;
			case 4:
				line = board[2] + board[5] + board[8];
				break;
			case 5:
				line = board[3] + board[6] + board[9];
				break;
			case 6:
				line = board[1] + board[5] + board[9];
				break;
			case 7:
				line = board[1] + board[5] + board[7];
				break;
			}
			// For X winner
			if (line.equals("XXX")) {
				return "X";
			}
			// For O winner
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		for (int square = 1; square < 10; square++) {
			if (Arrays.asList(board).contains(String.valueOf(square))) {
				break;
			} else if (square == 9) {
				return "draw";
			}
		}
		// To enter the X Or O at the exact place on board.
		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	/**
	 * @description Method to Create Computer getting its turn would like the
	 *              computer to play like me
	 * @param None
	 * 
	 */
	public void computerMove() {
		moveToDesiredLocation(); // calling the moveToDesiredLocation method
	}

	/**
	 * @description Method to Create game play who first and then next
	 * @param None
	 * 
	 */
	private void play() {
		tossToCheckWhoFirst(); // calling the tossToCheckWhoFirst method
		moveToDesiredLocation(); // calling the moveToDesiredLocation method
		if (turn.equals(player)) {
			turn = computer; // storing the value
		} else {
			turn = player;
		}
		computerMove(); // calling the computer move method
	}

	// Explanation How to implement the Computation
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Tic-Tac-Toe Game");
		TicTacToeGame tictactoegame = new TicTacToeGame();// Create Object related to Class
		tictactoegame.IntializingBoard();// relation between Main and InitializingBoard Method
		System.out.println("Welcome to 3*3 Tic Tac Toe Game");
		tictactoegame.printBoard(); // relation between Main and PrintBoard
		tictactoegame.chooseYourOption();// relation between Main and Player Option
		tictactoegame.play();
		tictactoegame.checkWinner();
	}

}
