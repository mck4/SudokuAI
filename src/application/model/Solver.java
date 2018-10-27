/** Solver.java **/
package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solver {
	// Answer array
	final ArrayList <Integer> answerArr = new ArrayList<Integer>();
	
	// Constructor
	public Solver() {
		// Adding the list of possible answers
		answerArr.add(1);
		answerArr.add(2);
		answerArr.add(3);
		answerArr.add(4);
		answerArr.add(5);
		answerArr.add(6);
		answerArr.add(7);
		answerArr.add(8);
		answerArr.add(9);
	}
	
	/** The row with the smallest # of zeros (at least 1) is returned **/
	public int checkRowsForZeros(Cell[][] boardArr) {
		
		int zCount = 0;		// Zero count for each row
		int minZero = 0;	// Smallest zero count found
		int iRowNr = 0;		// Row with smallest # of zeroes
		
		for(int i = 0; i < 9; i++){
			zCount = 0; // Reset for each row
			for ( int j = 0 ; j < 9; j ++){
				
				// Count # of zeros
				if (boardArr[i][j].getValue() == 0) 
					zCount++;
			}
			
			// By default, 0th row has smallest # of zeros
			if (minZero == 0) 
				minZero = zCount;
			// Does the current row have a smaller # of zeros? 
			else if (zCount < minZero && zCount != 0){
				minZero = zCount;
				iRowNr = i;
			}
		}
		
		return iRowNr;
	}
	
	/** The column with the smallest # of zeros (at least 1) is returned **/
	public int checkColsForZeros(Cell[][] boardArr){
		
		int zCount = 0;		// Zero count for each column
		int minZero = 0; 	// Smallest zero count found
		int iColNr = 0;		// Col with smallest # of zeroes
		
		for(int i = 0; i < 9; i++){
			zCount = 0; // Reset for each columnn
			for (int j = 0; j < 9; j++){
				
				// Count # of zeros
				if(boardArr[j][i].getValue() == 0)
					zCount++;
			}
			
			// By default, 0th column has smallest # of zeros
			if(minZero == 0)
				minZero = zCount;
			// Does the current col have a smaller # of zeros? 
			else if (zCount < minZero && zCount != 0){
				minZero = zCount;
				iColNr = i;
			}
		}
		
		return iColNr;
	}
	
	/** The square with the smallest # of zeros (at least 1) is returned **/
	public int checkSquaresForZeroes(Cell[][] boardArr){
		
		int zCount = 0;		// Zero count for each square
		int minZero = 0;	// Smallest zero count found
		int squareNr = 1;	// Square with smallest # of zeros
		
		// By default square 1 is the square with the smallest # of zeros
		zCount = Square.checkSQ1ForZeroes(boardArr);
		minZero = zCount;
		
		// Check square 2
		zCount = Square.checkSQ2ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr = 2;
		}
		
		// Check square 3
		zCount = Square.checkSQ3ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr = 3;
		}
		
		// Check square 4
		zCount = Square.checkSQ4ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr = 4;
		}
		
		// Check square 5
		zCount = Square.checkSQ5ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr = 5;
		}
		
		// Check square 6
		zCount = Square.checkSQ6ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr = 6;
		}
		
		// Check square 7
		zCount = Square.checkSQ7ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr = 7;
		}
		
		// Check square 8
		zCount = Square.checkSQ8ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr = 8;
		}
		
		// Check square 9
		zCount = Square.checkSQ9ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr = 9;
		}
		
		return squareNr;
	}
	
	// Given a row, column or square, an array of possible numbers will be returned
	public ArrayList<Integer> getPosNum(Cell[][] boardArr, int index, String type){
		
		// Get the AL of possible answers; by default, it is all of them
		ArrayList<Integer> posNum = (ArrayList<Integer>) this.answerArr.clone();
		

		if(type.equalsIgnoreCase("col")){
			
			int colNum = index; // Index is the col number in this case
			
			for(int i = 0; i < 9; i++){
				if(boardArr[i][colNum].getValue() != 0) {
					// Remove matches found
					posNum.remove(Integer.valueOf(boardArr[i][colNum].getValue()));
				}
			}
		}
		else if(type.equalsIgnoreCase("row")){ 
			int rowNum = index; // Index is the col number in this case

			for(int i = 0; i < 9; i++){
				if(boardArr[rowNum][i].getValue() != 0) {
					// Remove matches found
					posNum.remove(Integer.valueOf(boardArr[rowNum][i].getValue()));
				}
			}
		}
		else if(type.equalsIgnoreCase("square")){
			// Number to add to index when looping through
			int colOffset = 1;
			int rowOffset = 1;
			
			// Determine row offset
			if(index >= 1 && index <= 3) { 	// Row including 1, 2, 3
				rowOffset = 0;
			}
			else if (index >= 4 && index <= 5) { // Row including 4, 5, 6
				rowOffset = 3;
			}
			else if (index >= 6 && index <= 9) { // Row including 7, 8, 9
				rowOffset = 6;
			}
			
			// Determine column offset 
			if((3 % index ) == 0) { // Col including 3, 6, 9
				colOffset = 6;
			}
			else if ((3 % index) == 1) { // Col including 2, 5, 8
				colOffset = 3;
			}
			else if ((3 % index) == 2) { // Col including 1, 4, 7
				colOffset = 0;
			}
			
			
			for(int row = 0; row < 3; row++) {
				for(int col = 0; col < 3; col++ ) {
					
					if(boardArr[row + rowOffset][col + colOffset].getValue() != 0) {
						// Remove matches found
						posNum.remove(Integer.valueOf(boardArr[row + rowOffset][col + colOffset].getValue()));
					}
					
				}
			}
			
			
		}
		else {
			System.out.println("Invalid type");
		}
			
		return posNum;
		
	}
	
	public List checkRowsForNrs(Cell[][] boardArr, int[] posNum){
		
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
	}
	
}
