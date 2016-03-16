import java.util.List;

public class Displayer implements IDisplayer {

	private List<ICell> livingCells;

	public Displayer(List<ICell> cellsToDisplay) {
		this.livingCells = cellsToDisplay;
	}

	public void display() {
		String result = "";
		if (!livingCells.isEmpty()) {
			int horizontalMin = getMinimalHorizonalLivingCellPosition();
			int horizontalMax = getMaximalHorizonalLivingCellPosition();
			int verticalMin = getMinimalVerticalLivingCellPosition();
			int verticalMax = getMaximalVerticalLivingCellPosition();

			if (Math.abs(horizontalMax - horizontalMin) > 15 || Math.abs(verticalMax - verticalMin) > 70)
				System.out.println("Cells to far away from each other. Impossible to display.\nLiving cells: " + livingCells.size());
			else {
				horizontalMin -= 3;
				horizontalMax += 3;
				verticalMin -= 3;
				verticalMax += 3;

				for (int i = horizontalMin; i < horizontalMax; i++) {
					for (int j = verticalMin; j < verticalMax; j++)
						result += (livingCells.contains(new Cell(i, j))) ? "1 " : "0 ";
					result += "\n";
				}

				System.out.println("x:(" + horizontalMin + ", " + horizontalMax + ")\ny:(" + verticalMin + ", "
						+ verticalMax + ")\n" + result);
			}
		}
	}

	public void setNewCellsList(List<ICell> newCells) {
		this.livingCells = newCells;
	}
	
	private int getMinimalHorizonalLivingCellPosition() {
		int min = livingCells.get(0).getX();
		for (ICell cell : livingCells)
			if (cell.getX() < min)
				min = cell.getX();
		return min;
	}

	private int getMaximalHorizonalLivingCellPosition() {
		int max = livingCells.get(0).getX();
		for (ICell cell : livingCells)
			if (cell.getX() > max)
				max = cell.getX();
		return max;
	}

	private int getMinimalVerticalLivingCellPosition() {
		int min = livingCells.get(0).getY();
		for (ICell cell : livingCells)
			if (cell.getY() < min)
				min = cell.getY();
		return min;
	}

	private int getMaximalVerticalLivingCellPosition() {
		int max = livingCells.get(0).getY();
		for (ICell cell : livingCells)
			if (cell.getY() > max)
				max = cell.getY();
		return max;
	}
}
