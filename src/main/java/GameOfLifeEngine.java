import java.util.ArrayList;
import java.util.List;

public class GameOfLifeEngine implements IEngine {

	private List<ICell> cells;
	private List<ICell> emptySpaces;

	public GameOfLifeEngine(List<ICell> cells) {
		this.cells = cells;
		emptySpaces = new ArrayList<ICell>();
	}

	public List<ICell> reproduction() {
		List<ICell> temp = new ArrayList<ICell>();

		for (ICell cell : emptySpaces) {
			if (getNeighbourhoodWithoutEmpty(cell) == 3)
				temp.add(cell);
		}
		emptySpaces.clear();
		
		return temp;
	}

	private void addToEmptySpaces(ICell cell) {
		if (!emptySpaces.contains(cell))
			emptySpaces.add(cell);
	}

	public int getNeighbourhood(ICell cell) {
		
		int neighbours = 0;

		if (cell.getX() == 0 && cell.getY() == 0)
			neighbours = checkUpperLeft(cell);
		else if (cell.getX() == 9 && cell.getY() == 0)
			neighbours = checkUpperRight(cell);
		else if (cell.getX() > 0 && cell.getY() == 0)
			neighbours = checkUpperSection(cell);
		else if (cell.getX() == 0 && cell.getY() == 9)
			neighbours = checkLowerLeft(cell);
		else if (cell.getX() == 9 && cell.getY() < 9)
			neighbours = checkRightSection(cell);
		else if (cell.getX() == 0 && cell.getY() < 9)
			neighbours = checkLeftSection(cell);
		else if (cell.getX() == 9 && cell.getY() == 9)
			neighbours = checkLowerRight(cell);
		else if (cell.getX() > 0 && cell.getY() == 9)
			neighbours = checkLowerSection(cell);
		else
			neighbours = checkCenter(cell);

		return neighbours;
	}

	public int getNeighbourhoodWithoutEmpty(ICell cell) {
		int neighbours = 0;

		if (cell.getX() == 0 && cell.getY() == 0)
			neighbours = checkUpperLeftWithoutEmpty(cell);
		else if (cell.getX() == 9 && cell.getY() == 0)
			neighbours = checkUpperRightWithoutEmpty(cell);
		else if (cell.getX() > 0 && cell.getY() == 0)
			neighbours = checkUpperSectionWithoutEmpty(cell);
		else if (cell.getX() == 0 && cell.getY() == 9)
			neighbours = checkLowerLeftWithoutEmpty(cell);
		else if (cell.getX() == 9 && cell.getY() < 9)
			neighbours = checkRightSectionWithoutEmpty(cell);
		else if (cell.getX() == 0 && cell.getY() < 9)
			neighbours = checkLeftSectionWithoutEmpty(cell);
		else if (cell.getX() == 9 && cell.getY() == 9)
			neighbours = checkLowerRightWithoutEmpty(cell);
		else if (cell.getX() > 0 && cell.getY() == 9)
			neighbours = checkLowerSectionWithoutEmpty(cell);
		else
			neighbours = checkCenterWithoutEmpty(cell);

		return neighbours;
	}

	private int checkUpperLeft(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();

		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j));
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j));
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		else
			addToEmptySpaces(cell);
		return neighbours;
	}

	private int checkUpperRight(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j + 1));
		if (cells.contains(new Cell(i - 1, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j + 1));
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j));
		return neighbours;
	}

	private int checkUpperSection(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j));
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j));
		if (cells.contains(new Cell(i - 1, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j + 1));
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j + 1));
		if (cells.contains(new Cell(i + 1, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j + 1));
		return neighbours;
	}

	private int checkLowerLeft(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j - 1));
		if (cells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j - 1));
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j));
		return neighbours;
	}

	private int checkRightSection(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j - 1));
		if (cells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j - 1));
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j));
		if (cells.contains(new Cell(i - 1, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j + 1));
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j + 1));
		return neighbours;
	}

	private int checkLeftSection(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j - 1));
		if (cells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j - 1));
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j));
		if (cells.contains(new Cell(i + 1, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j + 1));
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j + 1));
		return neighbours;
	}

	private int checkLowerRight(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j - 1));
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j - 1));
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j));
		return neighbours;
	}

	private int checkLowerSection(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j - 1));
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j - 1));
		if (cells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j - 1));
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j));
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j));
		return neighbours;
	}

	private int checkCenter(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j - 1));
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j - 1));
		if (cells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j - 1));
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j));
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j));
		if (cells.contains(new Cell(i - 1, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i - 1, j + 1));
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i, j + 1));
		if (cells.contains(new Cell(i + 1, j + 1)))
			neighbours++;
		else
			addToEmptySpaces(new Cell(i + 1, j + 1));
		return neighbours;
	}

	private int checkUpperLeftWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();

		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		return neighbours;
	}

	private int checkUpperRightWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j + 1)))
			addToEmptySpaces(new Cell(i - 1, j + 1));
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		return neighbours;
	}

	private int checkUpperSectionWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j + 1)))
			neighbours++;
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j + 1)))
			neighbours++;
		return neighbours;
	}

	private int checkLowerLeftWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		return neighbours;
	}

	private int checkRightSectionWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j + 1)))
			neighbours++;
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		return neighbours;
	}

	private int checkLeftSectionWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j + 1)))
			neighbours++;
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		return neighbours;
	}

	private int checkLowerRightWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		return neighbours;
	}

	private int checkLowerSectionWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		return neighbours;
	}

	private int checkCenterWithoutEmpty(ICell cell) {
		int neighbours = 0;
		int i = cell.getX();
		int j = cell.getY();
		if (cells.contains(new Cell(i - 1, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j - 1)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j)))
			neighbours++;
		if (cells.contains(new Cell(i - 1, j + 1)))
			neighbours++;
		if (cells.contains(new Cell(i, j + 1)))
			neighbours++;
		if (cells.contains(new Cell(i + 1, j + 1)))
			neighbours++;
		return neighbours;
	}
}
