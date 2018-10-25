package application.model;

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
	
	public int checkColsforZeros()
	
	

}
