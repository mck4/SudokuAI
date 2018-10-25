package application.controller;

import java.io.FileReader;
import java.util.Scanner;

import application.Main;
import application.model.Board;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;

public class MainController implements EventHandler<ActionEvent> {
	
	ComboBox choice;
	
	@Override
	public void handle(ActionEvent event) {
		
		

	}
	
	// This method loads automatically when program is run
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
	
	public void loadPuzzles() {
		try {
			Scanner puzzlesFile = new Scanner(new FileReader("puzzles.txt"));
			
			//puzzlesFile.
		}
		catch(Exception e) {
			System.out.println("Could not find puzzles.txt.");
			System.exit(1);
		}
	}

}
