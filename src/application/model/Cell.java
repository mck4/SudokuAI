package application.model;

public class Cell {	
	
	int value;
	boolean isEmpty;
	
	public Cell(int value, boolean isEmpty) {
		this.value = value;
		this.isEmpty = isEmpty;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

}
