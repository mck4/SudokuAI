/** Solver.java **/
package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solver {
	
	final ArrayList <Integer> answerArr = new ArrayList<Integer>(); // Answer array
	Board board; // Board
	Cell[][] boardArr; // 2d Cell Array
	// Lists of unchecked rows, columns & squares
	ArrayList <Integer> rowsUnchecked = new ArrayList<Integer>();
	ArrayList <Integer> colsUnchecked = new ArrayList<Integer>();
	ArrayList <Integer> squaresUnchecked = new ArrayList<Integer>();
	ArrayList <Cell> changedCells = new ArrayList<Cell>();
	
	/** Constructor **/
	public Solver(Board board) {
		// Adding the list of possible answers
		this.answerArr.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		// Initializing Checked Lists
		resetChecked();
		
		// Get 2d array
		this.boardArr = board.getBoardArr();
	}
	
	/** Get the board arr **/
	public Cell[][] getBoardArr(){
		return this.boardArr;
	}
	
	/** Get the rows unchecked list **/
	public ArrayList <Integer> getRowsUnchecked(){
		return this.rowsUnchecked;
	}
	
	/** Get the cols unchecked list **/
	public ArrayList <Integer> getColsUnchecked(){
		return this.colsUnchecked;
	}
	
	/** Get the squares unchecked list **/
	public ArrayList <Integer> getSquaresUnchecked(){
		return this.squaresUnchecked;
	}
	
	/** Reset Checked rows, cols, and squares **/
	public void resetChecked( ) {
		this.rowsUnchecked.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8));
		this.colsUnchecked.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8));
		this.squaresUnchecked.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
	}
		
	
	/** Update the board **/
	public void updateBoard(int row, int col, int value) {
		// Update cell
		this.boardArr[row][col].setEmpty(false);
		this.boardArr[row][col].setValue(value);
	}
	
	/** The row with the smallest # of zeros (at least 1) is returned **/
	public int checkRowsForZeros() {
		
		int zCount = 0;		// Zero count for each row
		int minZero = 100;	// Smallest zero count found; by default an impossibly high number
		int iRowNr = -1;	// Row with smallest # of zeroes
		
		for(int i = 0; i < 9; i++){
			zCount = 0; // Reset for each row
			for ( int j = 0 ; j < 9; j ++){
				
				// Count # of zeros
				if (this.boardArr[i][j].getValue() == 0) 
					zCount++;
			}
			
			// Find the row with the smallest # of zeros
			if(zCount < minZero && zCount != 0 && this.rowsUnchecked.contains(Integer.valueOf(i))){
				minZero = zCount;
				iRowNr = i;
			}
		}
		return iRowNr;
	}
	
	/** The column with the smallest # of zeros (at least 1) is returned **/
	public int checkColsForZeros(){
		
		int zCount = 0;		// Zero count for each column
		int minZero = 100; 	// Smallest zero count found; by default an impossibly high number
		int iColNr = -1;    // Col with smallest # of zeroes
		
		for(int i = 0; i < 9; i++){
			zCount = 0; // Reset for each columnn
			for (int j = 0; j < 9; j++){
				
				// Count # of zeros
				if(this.boardArr[j][i].getValue() == 0)
					zCount++;
			}
			
			// Find the column with the smallest # of zeros
			if(zCount < minZero && zCount != 0  && this.colsUnchecked.contains(Integer.valueOf(i))){
				minZero = zCount;
				iColNr = i;
			}
		}
			
		return iColNr;
	}
	
	/** The square with the smallest # of zeros (at least 1) is returned **/
	public int checkSquaresForZeroes(){
		
		int zCount = 0;		// Zero count for each square
		int minZero = 100;	// Smallest zero count found; by default an impossibly high number
		int squareNr = -1;	// Square with smallest # of zeros
		
		if(this.squaresUnchecked.isEmpty())
			return -1; // This means no more squares can be checked for now
		
		// If its in the unchecked list, square 1 is the default
		if(this.squaresUnchecked.contains(Integer.valueOf(1))) {
			zCount = Square.checkSQ1ForZeroes(this.boardArr);
			if(zCount != 0) {
				minZero = zCount;
				squareNr = 1;
			}
		}
		
		// Check square 2
		zCount = Square.checkSQ2ForZeroes(this.boardArr);
		if (zCount <= minZero && zCount != 0 && this.squaresUnchecked.contains(Integer.valueOf(2))){
			minZero = zCount;
			squareNr = 2;
		}
		
		// Check square 3
		zCount = Square.checkSQ3ForZeroes(this.boardArr);
		if (zCount <= minZero && zCount != 0 && this.squaresUnchecked.contains(Integer.valueOf(3))){
			minZero = zCount;
			squareNr = 3;
		}
		
		// Check square 4
		zCount = Square.checkSQ4ForZeroes(this.boardArr);
		if (zCount <= minZero && zCount != 0 && this.squaresUnchecked.contains(Integer.valueOf(4))){
			minZero = zCount;
			squareNr = 4;
		}
		
		// Check square 5
		zCount = Square.checkSQ5ForZeroes(this.boardArr);
		if (zCount <= minZero && zCount != 0 && this.squaresUnchecked.contains(Integer.valueOf(5))){
			minZero = zCount;
			squareNr = 5;
		}
		
		// Check square 6
		zCount = Square.checkSQ6ForZeroes(this.boardArr);
		if (zCount <= minZero && zCount != 0 && this.squaresUnchecked.contains(Integer.valueOf(6))){
			minZero = zCount;
			squareNr = 6;
		}
		
		// Check square 7
		zCount = Square.checkSQ7ForZeroes(this.boardArr);
		if (zCount <= minZero && zCount != 0 && this.squaresUnchecked.contains(Integer.valueOf(7))){
			minZero = zCount;
			squareNr = 7;
		}
		
		// Check square 8
		zCount = Square.checkSQ8ForZeroes(this.boardArr);
		if (zCount <= minZero && zCount != 0 && this.squaresUnchecked.contains(Integer.valueOf(8))){
			minZero = zCount;
			squareNr = 8;
		}
		
		// Check square 9
		zCount = Square.checkSQ9ForZeroes(this.boardArr);
		if (zCount <= minZero && zCount != 0 && this.squaresUnchecked.contains(Integer.valueOf(9))){
			minZero = zCount;
			squareNr = 9;
		}
		
		return squareNr;
	}
	
	/** Given a row, column or square, an array of possible numbers will be returned **/
	public ArrayList<Integer> getPosNum(int index, String type){
		
		// Get the AL of possible answers; by default, it is all of them
		ArrayList<Integer> posNum = (ArrayList<Integer>) this.answerArr.clone();

		if(type.equalsIgnoreCase("col")){
			
			int colNum = index; // Index is the col number in this case
			
			for(int i = 0; i < 9; i++){
				if(this.boardArr[i][colNum].getValue() != 0) {
					// Remove matches found
					posNum.remove(Integer.valueOf(this.boardArr[i][colNum].getValue()));
				}
			}
		}
		else if(type.equalsIgnoreCase("row")){ 
			int rowNum = index; // Index is the col number in this case

			for(int i = 0; i < 9; i++){
				if(this.boardArr[rowNum][i].getValue() != 0) {
					// Remove matches found
					posNum.remove(Integer.valueOf(this.boardArr[rowNum][i].getValue()));
				}
			}
		}
		else if(type.equalsIgnoreCase("square")){
			// Number to add to index when looping through
			int colOffset = 0;
			int rowOffset = 0;
			
			
			// Determine row offset
			if(index >= 1 && index <= 3) { 	rowOffset = 0; 	}     // Row including sq# 1, 2, 3
			else if (index >= 4 && index <= 6) { rowOffset = 3; } // Row including sq# 4, 5, 6
			else if (index >= 7 && index <= 9) { rowOffset = 6; } // Row including sq# 7, 8, 9
			
			// Determine column offset 
			if((index % 3) == 0) { colOffset = 6; }      // Col including 3, 6, 9
			else if ((index % 3) == 1) { colOffset = 0; }  // Col including 1, 4, 7
			else if ((index % 3) == 2) { colOffset = 3; }  // Col including 2, 5, 8
			
						
			for(int row = 0; row < 3; row++) {
				for(int col = 0; col < 3; col++ ) {
					if(this.boardArr[row + rowOffset][col + colOffset].getValue() != 0) {
						// Remove matches found
						posNum.remove(Integer.valueOf(this.boardArr[row + rowOffset][col + colOffset].getValue()));
					}
				}
			}		
		}
		else {
			System.out.println("Invalid type"); // Shouldn't really happen but just in case
		}		
		return posNum;
	}
	
	
	/** Solving given a row **/
	public boolean checkRow(int rowNum, ArrayList<Integer> posNum) {
		boolean solutionFound = false;
		ArrayList <Integer> currCol = new ArrayList<Integer>();		// holds AL of column solutions
		ArrayList <Integer> currSquare = new ArrayList<Integer>();  // holds AL of square solutions
		
		// Remove this row from unchecked list
		this.rowsUnchecked.remove(Integer.valueOf(rowNum));
		
		// For each empty spot, check column and square
		for(int col = 0; col < 9; col++) {
			
			if(boardArr[rowNum][col].isEmpty) {
				
				// Clone the possible Number list so it can be modified for each empty slot
				ArrayList <Integer> posNumEdit = (ArrayList<Integer>) posNum.clone();
				
				// Current possible answers for this row
				currCol = getPosNum(col, "col");

				int square = Square.getCurrSquare(rowNum, col); // Get square
				currSquare = getPosNum(square, "square"); // Possible answers for current square
				
				// Eliminate unlikely answers for the empty spot
				for(Integer ans: posNum) {
					if(!currCol.contains(ans)) 
						posNumEdit.remove(ans);
					
					if(!currSquare.contains(ans)) 
						posNumEdit.remove(ans);
				}
				
				// Just one value is left in the possible answers; this the solution
				// Update board
				if(posNumEdit.size() == 1) {
					updateBoard(rowNum, col, posNumEdit.get(0));
					solutionFound = true;
					changedCells.add(boardArr[rowNum][col]);
				}
			}
		}
		return solutionFound;
	}
	
	/** Solving given a column **/
	public boolean checkCol(int colNum, ArrayList<Integer> posNum) {
		boolean solutionFound = false;
		ArrayList <Integer> currRow = new ArrayList<Integer>();    // holds AL of row solutions
		ArrayList <Integer> currSquare = new ArrayList<Integer>(); // holds AL of square solutions
		
		// Remove this column from unchecked list
		this.colsUnchecked.remove(Integer.valueOf(colNum));
	
		// For each empty spot, check row and square
		for(int row = 0; row < 9; row++) {
			
			if(boardArr[row][colNum].isEmpty) {
				
				// Clone the possible Number list so it can be modified for each empty slot
				ArrayList <Integer> posNumEdit = (ArrayList<Integer>) posNum.clone();
				
				// Current possible answers for this row
				currRow = getPosNum(row, "row");
				
				int square = Square.getCurrSquare(row, colNum); // Get square
				currSquare = getPosNum(square, "square"); // Possible answers for current square
				
				// Eliminate unlikely answers for the empty spot
				for(Integer ans: posNum) {
					if(!currRow.contains(ans)) 
						posNumEdit.remove(ans);
					
					if(!currSquare.contains(ans)) 
						posNumEdit.remove(ans);
				}
				
				// Just one value is left in the possible answers; this the solution
				// Update board
				if(posNumEdit.size() == 1) {
					updateBoard(row, colNum, posNumEdit.get(0));
					solutionFound = true;
					changedCells.add(boardArr[row][colNum]);
				}
			}
		}	
		return solutionFound;
	}
	
	/** Solving given a square **/
	public boolean checkSquare(int sqNum, ArrayList<Integer> posNum) {
		boolean solutionFound = false;
		ArrayList <Integer> currRow = new ArrayList<Integer>();		// holds AL of row solutions
		ArrayList <Integer> currCol = new ArrayList<Integer>();		// holds AL of column solutions
		
		// Number to add to index when looping through
		int colOffset = 0;
		int rowOffset = 0;

		// Determine row offset
		if(sqNum >= 1 && sqNum <= 3) { 	rowOffset = 0; 	}     // Row including sq# 1, 2, 3
		else if (sqNum >= 4 && sqNum <= 6) { rowOffset = 3; } // Row including sq# 4, 5, 6
		else if (sqNum >= 7 && sqNum <= 9) { rowOffset = 6; } // Row including sq# 7, 8, 9

		// Determine column offset 
		if((sqNum % 3) == 0) { colOffset = 6; 	}      // Col including 3, 6, 9
		else if ((sqNum % 3) == 1) { colOffset = 0; }  // Col including 1, 4, 7
		else if ((sqNum % 3) == 2) { colOffset = 3; }  // Col including 2, 5, 8

		// Remove this square from unchecked list
		this.squaresUnchecked.remove(Integer.valueOf(sqNum));
		
		// For each empty spot, check row and column
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				
				if(boardArr[row + rowOffset][col + colOffset].isEmpty) {
					
					// Clone the possible Number list so it can be modified for each empty slot
					ArrayList <Integer> posNumEdit = (ArrayList<Integer>) posNum.clone();
					
					// Get the Row and Col of current empty spot
					currRow = getPosNum(row + rowOffset, "row");
					currCol = getPosNum(col + colOffset, "col");
					
					//System.out.println("row "+ (row + rowOffset) + " col " + (col + colOffset));
					// Eliminate unlikely answers for the empty spot
					for(Integer ans: posNum) {
						if(!currRow.contains(ans)) 
							posNumEdit.remove(ans);
			
						if(!currCol.contains(ans)) 
							posNumEdit.remove(ans);
					}
					
					// Just one value is left in the possible answers; this the solution
					// Update board
					if(posNumEdit.size() == 1) {
						updateBoard((row + rowOffset), (col + colOffset), posNumEdit.get(0));
						solutionFound = true;
						changedCells.add(boardArr[row+rowOffset][col+colOffset]);
					}
				}
			}
		}	
		return solutionFound;
	}
	
	public ArrayList<Cell> getChangedCells() {
		return this.changedCells;
	}
	
	
}
