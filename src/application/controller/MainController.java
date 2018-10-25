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
	
	@Override
	public void handle(ActionEvent event) {
		
		

	}
	
	/** Whenever someone makes a choice on the combobox **/
	public void comboHandle(ActionEvent event) {
		System.out.println("hello");
		//Board board = Board.loadBoard(file, gridName);
		
	}
	
	/**  This method loads automatically when program is run **/
	public void initialize() {
		
		loadPuzzles();
		/*
		System.out.println("\nThis method loads automatically when program is run\n");
		
		String file = "puzzles.txt"; // Name of the file
		String gridName = "Grid 01"; // Should take any Grid that exists; also there's still 10 in the puzzles.txt which eh we don't need to change?
		
		Board board = Board.loadBoard(file, gridName); // Get that board!
		
		// Print the board!
		if(board != null)
			// PRINT 
			System.out.println(board.getName());
		
			for(int a=0; a<9; a++) 
			{
				for(int b=0; b<9; b++) 
				{
					if(((b+1) % 3) == 0)
						System.out.print(" "+ board.getArr()[a][b] + "|");
					else
						System.out.print(" "+ board.getArr()[a][b] + ".");
				}
				if(((a+1) % 3) == 0)
					System.out.print("\n--------------------------\n");
				else
					System.out.println(" ");
			}
			// END PRINT */
	}
	
	/** Loads the puzzles in the file to fill the comboBox with values **/
	public void loadPuzzles() {
		// Open puzzles.txt
		try {
			Scanner puzzlesFile = new Scanner(new FileReader("puzzles.txt"));  // Open
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
