package application.model;

public class Square {
	
	public static int getCurrSquare(int row, int col) {

		if((row >= 0 && row <= 2) && (col >= 0 && col <= 2)) { return 1; }

		if((row >= 0 && row <= 2) && (col >= 3 && col <= 5)) { return 2; }

		if((row >= 0 && row <= 2) && (col >= 6 && col <= 8)) { return 3; }

		if((row >= 3 && row <= 5) && (col >= 0 && col <= 2)) { return 4; }

		if((row >= 3 && row <= 5) && (col >= 3 && col <= 5)) { return 5; }

		if((row >= 3 && row <= 5) && (col >= 6 && col <= 8)) { return 6; }

		if((row >= 6 && row <= 8) && (col >= 0 && col <= 2)) { return 7; }

		if((row >= 6 && row <= 8) && (col >= 3 && col <= 5)) { return 8; }

		if((row >= 6 && row <= 8) && (col >= 6 && col <= 8)) { return 9; }

		return 0; // Shouldn't happen but just in case
	}

	public static int checkSQ1ForZeroes(Cell[][] boardArr){
	
		int zCount = 0; 
		
		for(int i = 0; i <= 2; i++){
			for (int j = 0; j < 3; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	public static int checkSQ2ForZeroes(Cell[][] boardArr){
		
		int zCount = 0; 
		
		for(int i = 0; i <= 2; i++){
			for (int j = 3; j < 6; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	public static int checkSQ3ForZeroes(Cell[][] boardArr){
		
		int zCount = 0; 
		
		for(int i = 0; i <= 2; i++){
			for (int j = 6; j < 9; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	public static int checkSQ4ForZeroes(Cell[][] boardArr){
		
		int zCount = 0; 
		
		for(int i = 3; i < 6; i++){
			for (int j = 0; j <= 2; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	public static int checkSQ5ForZeroes(Cell[][] boardArr){
		
		int zCount = 0; 
		
		for(int i = 3; i < 6; i++){
			for (int j = 3; j < 6; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	public static int checkSQ6ForZeroes(Cell[][] boardArr){
		
		int zCount = 0; 
		
		for(int i = 3; i < 6; i++){
			for (int j = 6; j < 9; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	public static int checkSQ7ForZeroes(Cell[][] boardArr){
		
		int zCount = 0; 
		
		for(int i = 6; i < 9; i++){
			for (int j = 0; j <= 2; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	public static int checkSQ8ForZeroes(Cell[][] boardArr){
		
		int zCount = 0; 
		
		for(int i = 6; i < 9; i++){
			for (int j = 3; j < 6; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	public static int checkSQ9ForZeroes(Cell[][] boardArr){
		
		int zCount = 0; 
		
		for(int i = 6; i < 9; i++){
			for (int j = 6; j < 9; j++){
				
				if (boardArr[i][j].getValue() == 0)
					zCount++;
				
			}
		}
		
		
		return zCount;
	}
	
	
}
