/** Board.java **/
package application.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	// Variables
	int answerArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	Cell[][] boardArr = new Cell[9][9]; // 2d board arr
	String name; // Name of board ie "Grid #"

	// Constructor
	public Board(Cell[][] arr, String name){
		// Each new board requires a 2d arr of Cells and a name
		this.boardArr = arr;
		this.name = name;
	}

	// Returns a new Board or null
	public static Board loadBoard(String file, String gridName){

		// Variables
		Cell[][] newBoardArr = new Cell[9][9];				// Temporary Cell 2D arr
		Board newBoard = null;								// The new Board

		// Open the file, populate the 2d array, generate new Board
		try {
			// Open the file
			Scanner infile = new Scanner(new FileReader(file));

			// Go to the line with the gridName
			while (infile.hasNext()) {
				if(gridName.equals(infile.nextLine()))
					break;
			}

			// Get the numbers
			for(int i = 0; i < 9; i++){ 							// For each row
				// Convert the current row (a string) to a char array
				char [] chNums = infile.nextLine().toCharArray(); 

				for(int j = 0; j < 9; j++){						// For each column				
					// Get the int
					int newCellint = Integer.parseInt(String.valueOf(chNums[j]));

					// Get the bool
					boolean newCellbool = false;
					if(newCellint == 0)
						newCellbool = true;

					// Create new cell
					Cell newCell = new Cell(newCellint, newCellbool);

					// Place cell into 2d array
					newBoardArr[i][j] = newCell;
				} 
			}
			
			// Create a new board
			newBoard = new Board(newBoardArr, gridName);

			// Close file
			infile.close();	
		} 
		catch ( FileNotFoundException e ){
			// If file not found...
			System.out.println( "File not found" );
			System.exit( 0 );
		}

		// Return the new board
		return newBoard;
	}

	// Get 2D Cell array
	public Cell[][] getArr(){
		return this.boardArr;
	}

	// Set a new 2D Cell array
	public void setArr(Cell[][] arr){
		this.boardArr = arr;
	}

	// Get name of board
	public String getName(){
		return this.name;
	}
}