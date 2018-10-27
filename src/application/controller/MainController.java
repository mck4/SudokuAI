/** MainController.java **/
package application.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import application.Main;
import application.model.Board;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MainController implements EventHandler<ActionEvent> {
	
	@FXML
	ComboBox <String> choice;	// The combobox
	ArrayList<String> puzzleListAL = new ArrayList<String>();	// AL which holds the name of the puzzles (for combobox)
	
	// The file the puzzles will be inside of
	final String filename = "puzzles.txt"; 
	
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
	
	// Sudoku cells in a 2d array
	public static Label [][] labels;
	

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
			
	}
	
	/** Method to handle the -> button being clicked **/
	@Override
	public void handle(ActionEvent event) {
		
		// when the button is pressed

	}
	
	/** Method to load sudoku numbers onto gui **/
	public void loadNums(Board board) {
		
		// Get those numbers onto the board
		for(int row=0; row<9; row++) {
			for(int col=0; col<9; col++) {
				labels[row][col].setText(String.valueOf(board.getArr()[row][col]));
			}
		}
	
	}
	
	/** Method that handles a choice on the combobox **/
	public void handleCBx(ActionEvent event) {
		// Get the choice
		String gridName = choice.getSelectionModel().selectedItemProperty().getValue();
		// Get the board
		Board board = Board.loadBoard(filename, gridName);
		// Load the numbers onto gui
		loadNums(board);

	}
	
	/** Method to fill the comboBox with values **/
	public void loadPuzzlesCBx() {
		// Open puzzles.txt
		try {
			Scanner puzzlesFile = new Scanner(new FileReader(filename));  	   // Open
			Pattern pattern = Pattern.compile("(Grid [0-9]+)$");			   // Pattern must match "Grid #"
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

}
