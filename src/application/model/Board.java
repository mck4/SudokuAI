package application.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	// Variables
	int answerArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	Cell[][] boardArr = new Cell[9][9];
	String name;

	// Constructor
	public Board(Cell[][] arr, String n) {
		this.boardArr = arr;
		this.name = n;

	}

	// Returns a new Board or null
	public static Board loadBoard(String file, String gridName) {

		// Variables
		Cell[][] newBoardArr = new Cell[9][9];				// Temporary Cell 2D array, we'll fill with vals
		// and use to make a new Board
		Board newBoard = null;								// The new Board to be generated
		String match = null;								// If gridName passed in is found, will have that value, otherwise null
		boolean isFound = false; 							// Necessary for finding given gridName

		// Open the file, see if gridName exists, populate the 2d array if it does, generate new Board
		try {
			// Open file to check if Grid supplied is found
			Scanner checkfile = new Scanner(new FileReader(file));

			// If found, exact match returned, else null
			// this is our board name
			match = checkfile.findWithinHorizon(gridName, 0);

			// If match is found set boolean value to true
			if( match != null) {
				isFound = true;
			}

			// Close file
			checkfile.close();

			// If the match was found...
			if(isFound) {
				// Open the file again
				Scanner infile = new Scanner(new FileReader(file));

				// Go to the line where the match was found
				while (infile.hasNext()) {
					if(match.equals(infile.nextLine()))
						break;
				}

				/* Get numbers now that we've skipped */
				for(int i = 0; i < 9; i++) { 							// For each row
					// Convert the current row of #s to a char array
					char [] chNums = infile.nextLine().toCharArray(); 

					for(int j = 0; j < 9; j++) {						// For each column				
						// Get the int
						int newCellint = Integer.parseInt(String.valueOf(chNums[j]));

						// Get the bool
						boolean newCellbool = false;
						if(newCellint == 0)
							newCellbool = true; // true if # is 0

						// Create new cell now that we have our bool and int
						Cell newCell = new Cell(newCellint, newCellbool);

						// Place cell into 2d array
						newBoardArr[i][j] = newCell;
					} 
				}
				/* End of populating Cell 2D array */

				newBoard = new Board(newBoardArr, match);

				// Close file since we're done with it
				infile.close();	

			}
			else {
				// The grid was not found, so exit
				System.out.println( gridName + " not found." );
				System.exit( 0 );
			}

		} // End try
		catch ( FileNotFoundException e ) {
			// If file not found...
			System.out.println( "File not found" );
			System.exit( 0 );
		}
		
		// Return the new board
		return newBoard;
	}

	// Get 2D Cell array
	public Cell[][] getArr() {
		return this.boardArr;
	}
	
	// Get name of board
	public String getName() {
		return this.name;
	}
}
