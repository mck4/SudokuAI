/** MainController.java **/
package application.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import application.Main;
import application.model.Board;
import application.model.Cell;
import application.model.Solver;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class MainController implements EventHandler<ActionEvent> {

	ArrayList<String> puzzleListAL = new ArrayList<String>();	// AL which holds the name of the puzzles (for combobox)	
	final String filename = "puzzles.txt";  // The file the puzzles will be inside of
	public static Label [][] labels; // Sudoku cells in a 2d array
	public static Solver solver;
	public static Board board;
	public static Cell [][] memory;
	boolean printOnce = false;
	int count = 0;

	@FXML
	ComboBox <String> choice;	// The combobox

	@FXML
	Label text = new Label();

	@FXML
	Label r0c0, r0c1, r0c2, r0c3, r0c4, r0c5, r0c6, r0c7, r0c8, // Sudoku cells
	r1c0, r1c1, r1c2, r1c3, r1c4, r1c5, r1c6, r1c7, r1c8,	 
	r2c0, r2c1, r2c2, r2c3, r2c4, r2c5, r2c6, r2c7, r2c8,
	r3c0, r3c1, r3c2, r3c3, r3c4, r3c5, r3c6, r3c7, r3c8,
	r4c0, r4c1, r4c2, r4c3, r4c4, r4c5, r4c6, r4c7, r4c8,
	r5c0, r5c1, r5c2, r5c3, r5c4, r5c5, r5c6, r5c7, r5c8,
	r6c0, r6c1, r6c2, r6c3, r6c4, r6c5, r6c6, r6c7, r6c8,
	r7c0, r7c1, r7c2, r7c3, r7c4, r7c5, r7c6, r7c7, r7c8,
	r8c0, r8c1, r8c2, r8c3, r8c4, r8c5, r8c6, r8c7, r8c8; 


	/**  This method loads automatically when program is run **/
	public void initialize() {
		loadPuzzlesCBx(); // Load the puzzles into combobox

		// Temp 2d array to get these labels into an array
		Label [][] labelsinit = {{r0c0, r0c1, r0c2, r0c3, r0c4, r0c5, r0c6, r0c7, r0c8},
				{r1c0, r1c1, r1c2, r1c3, r1c4, r1c5, r1c6, r1c7, r1c8},
				{r2c0, r2c1, r2c2, r2c3, r2c4, r2c5, r2c6, r2c7, r2c8},
				{r3c0, r3c1, r3c2, r3c3, r3c4, r3c5, r3c6, r3c7, r3c8},
				{r4c0, r4c1, r4c2, r4c3, r4c4, r4c5, r4c6, r4c7, r4c8},
				{r5c0, r5c1, r5c2, r5c3, r5c4, r5c5, r5c6, r5c7, r5c8},
				{r6c0, r6c1, r6c2, r6c3, r6c4, r6c5, r6c6, r6c7, r6c8},
				{r7c0, r7c1, r7c2, r7c3, r7c4, r7c5, r7c6, r7c7, r7c8},
				{r8c0, r8c1, r8c2, r8c3, r8c4, r8c5, r8c6, r8c7, r8c8}}; 

		// Have the public static Labels point to it; this works for whatever reason
		labels = labelsinit; 

		text.setText("Select a puzzle.");

	}

	/** Method to handle the "Next Step" button being clicked **/
	@Override
	public void handle(ActionEvent event) {
		int leastEmptyRow = 0;
		int leastEmptyCol = 0;
		int leastEmptySquare = 0;
		int numElim = 0;
		
		// array of possible answers
		ArrayList<Integer> posAnsCol;
		ArrayList<Integer> posAnsRow;
		ArrayList<Integer> posAnsSquare;

		// if someone presses the button but no board has been loaded
		if(board == null)
			return;

		// Check if it's solved
		if(board.isSolved() || solver.checkIfSolved()){
			// Set as solved!
			board.setIsSolved(true);
			text.setText(board.getName() + " is solved!");
			
			// We only want this to print once
			if(printOnce == false){
				System.out.println(board.getName() + " is solved!");
				printOnce = true;
			}
			
			return;
		}
		

		count++;
		
		// when the button is pressed
		//System.out.println(count);
		
		// First check squares
		if((leastEmptySquare = solver.checkSquaresForZeroes()) != -1){
			boolean solutionFound = false;
			
			posAnsSquare = solver.getPosNum(leastEmptySquare, "square");
			solutionFound = solver.checkSquare(leastEmptySquare, posAnsSquare);
			
			while(solutionFound != true) {
				leastEmptySquare = solver.checkSquaresForZeroes();
				if(leastEmptySquare == -1)
					break;
				posAnsSquare = solver.getPosNum(leastEmptySquare, "square");
				solutionFound = solver.checkSquare(leastEmptySquare, posAnsSquare);
				
			}
			
			// print
			if(solutionFound == true || leastEmptySquare != -1){
				text.setText("In square " + leastEmptySquare + " we check the corresponding row and column to find solutions");
				printBoardText("In square " + leastEmptySquare + " we check the corresponding row and column to find solutions");
			}
			else
				text.setText("Checking squares yielded no results, keep clicking");
			
			// update board
			board.setArr(solver.getBoardArr());
			loadNums(board);
		}
		// Then check columns
		else if((leastEmptyCol = solver.checkColsForZeros()) != -1){
			boolean solutionFound = false;
			
			posAnsCol = solver.getPosNum(leastEmptyCol, "col");
			solutionFound = solver.checkCol(leastEmptyCol, posAnsCol);
			
			while(solutionFound != true) {
				leastEmptyCol = solver.checkColsForZeros();
				if(leastEmptyCol == -1)
					break;
				posAnsCol = solver.getPosNum(leastEmptyCol, "col");
				solutionFound = solver.checkCol(leastEmptyCol, posAnsCol);
				
			}
			
			// print
			if(solutionFound == true || leastEmptyCol != -1){
				text.setText("In column "  + (leastEmptyCol + 1) + " we check the corresponding square and row to find solutions.");
				printBoardText("In column "  + (leastEmptyCol + 1) + " we check the corresponding square and row to find solutions.");
			}
			else
				text.setText("Checking columns yielded no results, keep clicking");
			
			// update board
			board.setArr(solver.getBoardArr());
			loadNums(board);
		}
		// Then check rows
		else if((leastEmptyRow = solver.checkRowsForZeros()) != -1){

			boolean solutionFound = false;

			posAnsRow = solver.getPosNum(leastEmptyRow, "row");
			solutionFound = solver.checkRow(leastEmptyRow, posAnsRow);

			while(solutionFound != true) {
				leastEmptyRow = solver.checkRowsForZeros();
				if(leastEmptyRow == -1)
					break;
				posAnsRow = solver.getPosNum(leastEmptyRow, "row");
				solutionFound = solver.checkRow(leastEmptyRow, posAnsRow);

			}

			// print
			if(solutionFound == true || leastEmptyRow != -1){
				text.setText("In row "  + (leastEmptyRow + 1) + " we check the corresponding square and column to find solutions.");
				printBoardText("In row "  + (leastEmptyRow + 1) + " we check the corresponding square and column to find solutions.");
			}
			else
				text.setText("Checking rows yielded no results, keep clicking");
			
			// update board
			board.setArr(solver.getBoardArr());
			loadNums(board);
			
			//solver.resetChecked();

		}
		// If the above don't work, use the elimination method
		else if((numElim = solver.findNumMost()) != -1){
			
			boolean solutionFound = false;
			
			solutionFound = solver.eliminate(numElim);

			while(solutionFound != true) {
				numElim = solver.findNumMost();
				if(numElim == -1)
					break;
				solutionFound = solver.eliminate(numElim);
			}

			// print
			if(solutionFound == true || numElim  != -1){
				text.setText("We eliminate possible columns, rows, and squares that "  + numElim + " appears in.");
				printBoardText("We eliminate possible columns, rows, and squares that "  + numElim + " appears in.");
			}
			else
				text.setText("Elminating rows, columns and squares yielded no results, keep clicking");
			
			// update board
			board.setArr(solver.getBoardArr());
			loadNums(board);

			// Reset values
			solver.resetChecked();
		}
		
		// reset
		count = 0;
	}
	
	/** Method to print output in text form since we can only move linearly **/
	public void printBoardText(String text){
		
		for(int row=0; row<9; row++){
			for(int col=0; col<9; col++){
				if((col +1) % 3 == 0)
					System.out.print(board.getBoardArr()[row][col] + "|");
				else
					System.out.print(board.getBoardArr()[row][col] + ".");
				if((col +1) % 9 == 0)
					System.out.println("");
			}
			if((row +1) % 3 == 0)
				System.out.println("__________________");
		}
		
		// print text explaining what happened
		System.out.println(text + "\n");

	}

	/** Method to load sudoku numbers onto gui **/
	public void loadNums(Board board) {

		// Get those numbers onto the board
		for(int row=0; row<9; row++) {
			for(int col=0; col<9; col++) {
				labels[row][col].setText(String.valueOf(board.getBoardArr()[row][col]));
				if (count != 0) 
					checkChangedCells(row, col);
			}
		}

	}

	/** Method that handles a choice on the combobox **/
	public void handleCBx(ActionEvent event) {
		// Get the choice
		String gridName = choice.getSelectionModel().selectedItemProperty().getValue();
		//System.out.println(count);
		// Get the board
		board = Board.loadBoard(filename, gridName);
		
		// Load the numbers onto gui
		loadNums(board);

		// Solver
		solver = new Solver(board);

		// Set initial count as 0
		count = 0;

		text.setText("Click 'Next Step' to begin.");
		printBoardText("INITIAL BOARD");

	}

	/** Method to fill the comboBox with values **/
	public void loadPuzzlesCBx() {
		// Open puzzles.txt
		try {
			Scanner puzzlesFile = new Scanner(new FileReader(filename));  	   // Open
			Pattern pattern = Pattern.compile("(Grid [0-9]+.*)");			   // Pattern must match "Grid #"
			Matcher match;													   // For found matches
			// Look for matches
			while(puzzlesFile.hasNext()) {
				match = pattern.matcher(puzzlesFile.nextLine());
				if (match.find())
					puzzleListAL.add(match.group(0));						   // If match found, add to AL of puzzles
			}

			// Make an ObservableList of the AL of puzzles
			choice.setItems(FXCollections.observableArrayList(puzzleListAL));  // Set on the GUI
			puzzlesFile.close();											   // Close file
		}
		// Something went wrong
		catch(Exception e) {
			System.out.println("Could not find puzzles.txt.");
			System.exit(1);
		}
	}

	/** Update the board, show what changed **/
	public boolean checkChangedCells(int row, int col) {
		
		if(solver.getChangedCells() != null) {
			for(Cell cell: solver.getChangedCells()) {
				if (cell.getIndex()[0] == row && cell.getIndex()[1] == col) {
					labels[row][col].setTextFill(Color.BLUE);
					solver.getChangedCells().remove(cell);
					return true;
				}
			}
		}
		labels[row][col].setTextFill(Color.BLACK);
		return false;
	}
	
}
