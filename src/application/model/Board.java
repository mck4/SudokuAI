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
	
	public Board(Cell[][] arr, String n) {
		this.boardArr = arr;
		this.name = n;
		
	}
	
	public static Board loadBoard(String file, String gridName) {
		
		
		String [] nums; // String array for tokens
		
		/* stuff will go here */
		
		
		return null;
	}
	
	
}
