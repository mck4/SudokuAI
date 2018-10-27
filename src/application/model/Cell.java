/** Cell.java **/
package application.model;

public class Cell {	
	
	// Variables
	int value;
	boolean isEmpty;
	
	// Constructor
	public Cell(int value, boolean isEmpty) {
		this.value = value;
		this.isEmpty = isEmpty;
	}

	// toString 
	public String toString() {
		if(this.value != 0)
			return String.valueOf(this.value);
		else
			return " ";
	}
	
	// Checks if the cell is empty
	public boolean isEmpty() {
		return isEmpty;
	}
	
	// Gets the value of the cell
	public int getValue() {
		return this.value;
	}

	// Sets the value of the cell
	public void setValue(int value) {
		this.value = value;
	}

	// Set the value of isEmpty
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

}
