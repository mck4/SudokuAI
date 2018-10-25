package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solver {
	
	public int checkRowsForZeros(Cell[][] boardArr){
		
		int zCount = 0;
		int minZero = 0;
		int iRowNr = 0;
		
		for(int i = 0; i < 9; i++){
			for ( int j = 0 ; j < 9; j ++){
				if (boardArr[i][j].getValue() == 0)
					zCount++;
			}
			
			if (minZero == 0) 
				minZero = zCount;
				
			
			else if (zCount < minZero && zCount != 0){
				minZero = zCount;
				iRowNr = i;
			}
		}
		
		return iRowNr;
	}
	
	public int checkColsforZeros(Cell[][] boardArr){
		
		int zCount = 0;
		int minZero = 0; 
		int iColNr = 0;
		
		for(int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				
				if(boardArr[j][i].getValue() == 0)
					zCount++;
			}
			
			if(minZero == 0)
				minZero = zCount;
			else if (zCount < minZero && zCount != 0){
				minZero = zCount;
				iColNr = i;
			}
		}
		
		return iColNr;
	}
	
	public int checkSquaresforZeroes(Cell[][] boardArr){
		
		int zCount = 0;
		int minZero = 0;
		int squareNr = 1;
		
		zCount = Square.checkSQ1ForZeroes(boardArr);
		minZero = zCount;
		
		zCount = Square.checkSQ2ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr++;
		}
		
		zCount = Square.checkSQ3ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr++;
		}
		
		zCount = Square.checkSQ4ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr++;
		}
		
		zCount = Square.checkSQ5ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr++;
		}
		
		zCount = Square.checkSQ6ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr++;
		}
		
		zCount = Square.checkSQ7ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr++;
		}
		
		zCount = Square.checkSQ8ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr++;
		}
		
		zCount = Square.checkSQ9ForZeroes(boardArr);
		if (zCount < minZero && zCount != 0){
			minZero = zCount;
			squareNr++;
		}
		
		return squareNr;
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
