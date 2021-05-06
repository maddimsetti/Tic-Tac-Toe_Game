package tictactoe;

/**
 * @description create Class for defining the TicTacToeGame
 * @param None
 * 
 */
public class TicTacToeGame {
	static String[] board;

	/**
	 * @description Private Method to initializing TicTacToeBoard and set the board
	 *              to all empty values
	 * @param None
	 * 
	 */
	private void IntializingBoard() {
		for (int a = 0; a < 9; a++) { // for loop to initializing board
			board[a] = String.valueOf(a + 1); //values stores in array string
		}
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
	}

}
