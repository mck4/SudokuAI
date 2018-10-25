package application.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.Main;
import application.model.Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;

public class MainController implements EventHandler<ActionEvent> {
	
	@FXML
	ComboBox <String> choice;
	ArrayList<String> puzzleListAL = new ArrayList<String>();
	final String filename = "puzzles.txt";
	
	@Override
	public void handle(ActionEvent event) {
		
		

	}
	
	/** Whenever someone makes a choice on the combobox **/
	public void handleCBx(ActionEvent event) {
		// Get the choice
		String gridName = choice.getSelectionModel().selectedItemProperty().getValue();
		// Get the board
		Board board = Board.loadBoard(filename, gridName);


	}

	/**  This method loads automatically when program is run **/
	public void initialize() {
		
		loadPuzzlesCBx(); // Load the puzzles into combobox
		
	}
	
	/** Loads the puzzles in the file to fill the comboBox with values **/
	public void loadPuzzlesCBx() {
		// Open puzzles.txt
		try {
			Scanner puzzlesFile = new Scanner(new FileReader(filename));  // Open
			Pattern pattern = Pattern.compile("(Grid [0-9]+)$");			   // Pattern must match "Grid #"
			Matcher match;													   // For found matches
			// Look for matches
			while(puzzlesFile.hasNext()) {
				match = pattern.matcher(puzzlesFile.nextLine());
				if (match.find())
					puzzleListAL.add(match.group(0));						  // If match found, add to AL of puzzles
			}
			
			// Make an ObservableList of the AL of puzzles
			choice.setItems(FXCollections.observableArrayList(puzzleListAL)); // Set on the GUI
			puzzlesFile.close();											  // Close file
		}
		// Something went wrong
		catch(Exception e) {
			System.out.println("Could not find puzzles.txt.");
			System.exit(1);
		}
	}

}
