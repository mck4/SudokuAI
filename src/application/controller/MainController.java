package application.controller;

import application.Main;
import application.model.Board;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MainController implements EventHandler<ActionEvent> {
	
	@Override
	public void handle(ActionEvent event) {
		
		

	}
	
	// This method loads automatically when program is run
	public void initialize() {
		
		System.out.println("\nThis method loads automatically when program is run\n");
		
		String file = "puzzles.txt";
		String gridName = "Grid 05";
		
		Board board = Board.loadBoard(file, gridName);
		
		// Print the board!
		if(board != null)
			/* PRINT */
			System.out.println(board.getName());
		
			for(int a=0; a<9; a++) 
			{
				for(int b=0; b<9; b++) 
				{
					if(((b+1) % 3) == 0)
						System.out.print(" "+ board.getArr()[a][b] + "|");
					else
						System.out.print(" "+ board.getArr()[a][b] + " ");
				}
				if(((a+1) % 3) == 0)
					System.out.print("\n--------------------------\n");
				else
					System.out.println(" ");
			}
			/* END PRINT */
	}
	

}
