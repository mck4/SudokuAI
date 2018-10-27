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
	
	/** Constructor **/
	public Solver(Board board) {
		// Adding the list of possible answers
		this.answerArr.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		// Initializing Checked Lists
		resetChecked();
		
		// Get 2d array
		this.boardArr = board.getBoardArr();
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
			int colOffset = 1;
			int rowOffset = 1;
			
			// Determine row offset
			if(index >= 1 && index <= 3) { 	rowOffset = 0; 	}     // Row including 1, 2, 3
			else if (index >= 4 && index <= 5) { rowOffset = 3; } // Row including 4, 5, 6
			else if (index >= 6 && index <= 9) { rowOffset = 6; } // Row including 7, 8, 9
			
			// Determine column offset 
			if((3 % index ) == 0) { colOffset = 6; 	}      // Col including 3, 6, 9
			else if ((3 % index) == 1) { colOffset = 3; }  // Col including 2, 5, 8
			else if ((3 % index) == 2) { colOffset = 0; }  // Col including 1, 4, 7
			
			
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
			System.out.println("Invalid type");
		}
			
		return posNum;
		
	}
	
	
	public void checkRow(int rowNum, ArrayList<Integer> posNum) {
		
		this.rowsUnchecked.remove(Integer.valueOf(rowNum));
		System.out.println(this.rowsUnchecked);
		
	}
	
	public void checkCol(int colNum, ArrayList<Integer> posNum) {
		
		this.colsUnchecked.remove(Integer.valueOf(colNum));
		System.out.println(this.colsUnchecked);
		
	}
	
	public void checkSquare(int sqNum, ArrayList<Integer> posNum) {
		
		this.squaresUnchecked.remove(Integer.valueOf(sqNum));
		System.out.println(this.squaresUnchecked);
		
	}
	/*public List checkRowsForNrs(Cell[][] boardArr, int[] posNum){
		
		List checkNr = Arrays.asList(posNum);
		for(int i = 0; i < 9; i++){
			for (int j = 0; j < 9; i++){
				
				if (checkNr.contains(boardArr[i][j].getValue()) == true)
					checkNr.remove(boardArr[i][j].getValue());
				
			}
			
		}
		if(checkNr.size() != 1)
			checkNr = checkColsForNrs(boardArr, checkNr);
			
			
		return checkNr;
	}
	
	public List checkColsForNrs(Cell[][] boardArr, List checkNr){
		
		for(int i = 0; i < 9; i++){
			for (int j = 0; j < 9; i++){
				
				if (checkNr.contains(boardArr[j][i].getValue()) == true)
					checkNr.remove(boardArr[j][i].getValue());
				
			}
			
		}
		if(checkNr.size() != 1)
			checkNr = checkSQsForNrs(boardArr, checkNr);
		
		return checkNr;
	}
	
	public List checkSQsForNrs(Cell[][] boardArr, List checkNr){
	
		return checkNr;
	}*/
	
}
