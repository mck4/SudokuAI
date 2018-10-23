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
		try{
			Scanner infile = new Scanner(new FileReader(file));
		}
		catch ( FileNotFoundException e ) {
			System.out.println("File not found");
			System.exit( 0 );
		}
		
	
	}
	
	
}
