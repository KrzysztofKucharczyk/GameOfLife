import java.util.ArrayList;
import java.util.List;

public class GameOfLifeEngine implements IEngine {

	private List<ILivingCell> cells;
	private List<ILivingCell> deadCellsAroundLivingOnes;

	public GameOfLifeEngine(List<ILivingCell> cells) {
		this.cells = cells;
		deadCellsAroundLivingOnes = new ArrayList<ILivingCell>();
	}

	public List<ILivingCell> checkCells() {
		List<ILivingCell> newList = new ArrayList<ILivingCell>();

		for (ILivingCell cell : cells) {
			int neighbours = findAllLivingCellsAroundCoordinates(cell.getX(), cell.getY());
			if ((neighbours == 2 || neighbours == 3))
				newList.add(new LivingCell(cell.getX(), cell.getY()));
		}
		return newList;
	}

	public List<ILivingCell> reproduction() {
		List<ILivingCell> reproducedCells = new ArrayList<ILivingCell>();
		for (ILivingCell cell : cells)
			findAllDeadCellsAroundCoordinates(cell.getX(), cell.getY());

		for (ILivingCell cell : deadCellsAroundLivingOnes) {
			if (findAllLivingCellsAroundCoordinates(cell.getX(), cell.getY()) == 3)
				reproducedCells.add(cell);
		}

		deadCellsAroundLivingOnes.clear();
		return reproducedCells;
	}

	private void addToEmptySpaces(ILivingCell cell) {
		if (!deadCellsAroundLivingOnes.contains(cell))
			deadCellsAroundLivingOnes.add(cell);
	}

	private int findAllLivingCellsAroundCoordinates(int i, int j) {
		int neighbours = 0;

		for (int xCounter = -1; xCounter <= 1; xCounter++) {
			if (cells.contains(new LivingCell(i - xCounter, j - 1)))
				neighbours++;
			if (cells.contains(new LivingCell(i - xCounter, j + 1)))
				neighbours++;
		}

		if (cells.contains(new LivingCell(i - 1, j)))
			neighbours++;
		if (cells.contains(new LivingCell(i + 1, j)))
			neighbours++;

		return neighbours;
	}

	private void findAllDeadCellsAroundCoordinates(int i, int j) {
		for (int xCounter = -1; xCounter <= 1; xCounter++)
			if (!cells.contains(new LivingCell(i - xCounter, j - 1)))
				addToEmptySpaces(new LivingCell(i - xCounter, j - 1));

		for (int xCounter = -1; xCounter <= 1; xCounter++)
			if (!cells.contains(new LivingCell(i - xCounter, j + 1)))
				addToEmptySpaces(new LivingCell(i - xCounter, j + 1));

		if (!cells.contains(new LivingCell(i - 1, j)))
			addToEmptySpaces(new LivingCell(i - 1, j));
		if (!cells.contains(new LivingCell(i + 1, j)))
			addToEmptySpaces(new LivingCell(i + 1, j));

	}
}