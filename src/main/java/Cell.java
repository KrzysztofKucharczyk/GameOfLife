
public class Cell implements ICell {

	private int x, y;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
	        return false;
	    }
	    if (!Cell.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Cell other = (Cell) obj;
	    if(this.x != other.getX() || this.y != other.getY())
	    	return false;

	    return true;
	}
	
	@Override
	public String toString() {
		return new String("(x: " + this.x + ", y: " + y + ")");
	}

}
