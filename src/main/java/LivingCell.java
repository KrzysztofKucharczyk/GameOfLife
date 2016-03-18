
public class LivingCell implements ILivingCell {

	private int x, y;
	
	public LivingCell(int x, int y) {
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
	    if (!LivingCell.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final LivingCell other = (LivingCell) obj;
	    if(this.x != other.getX() || this.y != other.getY())
	    	return false;

	    return true;
	}
	
	@Override
	public int hashCode() {
		int result = 4;
		
		result += 31* result + new Integer(x).hashCode();
		
		return result;
		
	};
	
	@Override
	public String toString() {
		return new String("(x: " + this.x + ", y: " + y + ")");
	}

}
