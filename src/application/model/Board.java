package application.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	
	
	int answerArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	Cell[][] boardArr = new Cell[9][9];
	
	public Board() {
		
	}
	
	public static void loadBoard(String file) {
		
		String [] nums; // String array for tokens
		
		// Read in the file
		try {
			Scanner infile = new Scanner(new FileReader(file));
			
			String gridName = infile.nextLine();
			
			while(infile.hasNext()) {
				// GET nums here
			}
			
			// Debug
			System.out.println("Grid name " + gridName);
		}
		catch ( FileNotFoundException e ) {
			System.out.println("File not found");
			System.exit( 0 );
		}
		
	
	}
	
	
}
