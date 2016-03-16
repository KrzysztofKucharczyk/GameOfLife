import java.util.ArrayList;
import java.util.List;

public class GameOfLifeEngine implements IEngine {

	private List<ICell> livingCells;
	private List<ICell> deadCellsAroundLivingOnes;

	public GameOfLifeEngine(List<ICell> cells) {
		this.livingCells = cells;
		deadCellsAroundLivingOnes = new ArrayList<ICell>();
	}

	public List<ICell> checkLivingCells() {
		List<ICell> newList = new ArrayList<ICell>();

		for (ICell cell : livingCells) {
			int neighbours = findAllLivingCellsAroundCoordinates(cell.getX(), cell.getY());
			if ((neighbours == 2 || neighbours == 3))
				newList.add(new Cell(cell.getX(), cell.getY()));
		}
		return newList;
	}

	public List<ICell> reproduction() {
		List<ICell> reproducedCells = new ArrayList<ICell>();
		for (ICell cell : livingCells)
			findAllDeadCellsAroundCoordinates(cell.getX(), cell.getY());

		for (ICell cell : deadCellsAroundLivingOnes) {
			if (findAllLivingCellsAroundCoordinates(cell.getX(), cell.getY()) == 3)
				reproducedCells.add(cell);
		}

		deadCellsAroundLivingOnes.clear();
		return reproducedCells;
	}

	private void addToEmptySpaces(ICell cell) {
		if (!deadCellsAroundLivingOnes.contains(cell))
			deadCellsAroundLivingOnes.add(cell);
	}

	private int findAllLivingCellsAroundCoordinates(int i, int j) {
		int neighbours = 0;
		if (livingCells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		if (livingCells.contains(new Cell(i, j - 1)))
			neighbours++;
		if (livingCells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		if (livingCells.contains(new Cell(i - 1, j)))
			neighbours++;
		if (livingCells.contains(new Cell(i + 1, j)))
			neighbours++;
		if (livingCells.contains(new Cell(i - 1, j + 1)))
			neighbours++;
		if (livingCells.contains(new Cell(i, j + 1)))
			neighbours++;
		if (livingCells.contains(new Cell(i + 1, j + 1)))
			neighbours++;
		return neighbours;
	}

	private int findAllDeadCellsAroundCoordinates(int i, int j) {
		int neighbours = 0;
		if (!livingCells.contains(new Cell(i - 1, j - 1)))
			addToEmptySpaces(new Cell(i - 1, j - 1));
		if (!livingCells.contains(new Cell(i, j - 1)))
			addToEmptySpaces(new Cell(i, j - 1));
		if (!livingCells.contains(new Cell(i + 1, j - 1)))
			addToEmptySpaces(new Cell(i + 1, j - 1));
		if (!livingCells.contains(new Cell(i - 1, j)))
			addToEmptySpaces(new Cell(i - 1, j));
		if (!livingCells.contains(new Cell(i + 1, j)))
			addToEmptySpaces(new Cell(i + 1, j));
		if (!livingCells.contains(new Cell(i - 1, j + 1)))
			addToEmptySpaces(new Cell(i - 1, j + 1));
		if (!livingCells.contains(new Cell(i, j + 1)))
			addToEmptySpaces(new Cell(i, j + 1));
		if (!livingCells.contains(new Cell(i + 1, j + 1)))
			addToEmptySpaces(new Cell(i + 1, j + 1));
		return neighbours;
	}

	// -----------------------------------

}