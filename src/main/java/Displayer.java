import java.util.List;

public class Displayer implements IDisplayer {

	private List<ILivingCell> cells;
	private final static int MAX_HORIZONTAL_VALUE = 70;
	private final static int MIN_HORIZONTAL_VALUE = 20;
	private final static String deadCellSymbol = " . ";
	private final static String aliveCellSymbol = " O ";
	

	public Displayer(List<ILivingCell> cellsToDisplay) {
		this.cells = cellsToDisplay;
	}

	public void display() {
		String result = "";
		if (!cells.isEmpty()) {
			int horizontalMin = getMinimalHorizonalLivingCellPosition();
			int horizontalMax = getMaximalHorizonalLivingCellPosition();
			int verticalMin = getMinimalVerticalLivingCellPosition();
			int verticalMax = getMaximalVerticalLivingCellPosition();

			if (Math.abs(horizontalMax - horizontalMin) > MAX_HORIZONTAL_VALUE
					|| Math.abs(verticalMax - verticalMin) > MIN_HORIZONTAL_VALUE)
				System.out.println("Cells to far away from each other. Impossible to display.\nLiving cells: "
						+ cells.size());
			else {
				horizontalMin -= 3;
				horizontalMax += 3;
				verticalMin -= 3;
				verticalMax += 3;

				for (int i = horizontalMin; i < horizontalMax; i++) {
					for (int j = verticalMin; j < verticalMax; j++)
						result += (cells.contains(new LivingCell(i, j))) ? aliveCellSymbol : deadCellSymbol;
					result += "\n";
				}

				System.out.println("x:(" + horizontalMin + ", " + horizontalMax + ")\ny:(" + verticalMin + ", "
						+ verticalMax + ")\n" + result);
			}
		}
	}

	public void setNewCellsList(List<ILivingCell> newCells) {
		this.cells = newCells;
	}

	private int getMinimalHorizonalLivingCellPosition() {
		int min = cells.get(0).getX();
		for (ILivingCell cell : cells)
			if (cell.getX() < min)
				min = cell.getX();
		return min;
	}

	private int getMaximalHorizonalLivingCellPosition() {
		int max = cells.get(0).getX();
		for (ILivingCell cell : cells)
			if (cell.getX() > max)
				max = cell.getX();
		return max;
	}

	private int getMinimalVerticalLivingCellPosition() {
		int min = cells.get(0).getY();
		for (ILivingCell cell : cells)
			if (cell.getY() < min)
				min = cell.getY();
		return min;
	}

	private int getMaximalVerticalLivingCellPosition() {
		int max = cells.get(0).getY();
		for (ILivingCell cell : cells)
			if (cell.getY() > max)
				max = cell.getY();
		return max;
	}
}
