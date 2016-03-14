import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameOfLife {

	private List<ICell> cells = new ArrayList<ICell>();
	
	private Scanner scanner = new Scanner(System.in);

	public void getPresetCells() {
		int amountOfInputs = scanner.nextInt();

		for (int i = 0; i < amountOfInputs; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			cells.add(new Cell(x, y));
		}
	}

	public void setNewList(List<ICell> cells) {
		this.cells = cells;
	}
	
	public List<ICell> live() {
		IEngine engine = new GameOfLifeEngine(cells);
		List<ICell> newList = new ArrayList<ICell>();
		
		for(ICell cell : cells) {
			int neighbours = engine.getNeighbourhood(cell);
			if ((neighbours == 2 || neighbours == 3))
				newList.add(new Cell(cell.getX(), cell.getY()));
			
		}
		newList.addAll(engine.reproduction());

		return newList;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				result += (cells.contains(new Cell(i, j))) ? "1 " : "0 ";
			result += "\n";
		}
		return result;
	}

	public static void main(String[] args) {
		GameOfLife gol = new GameOfLife();
		gol.getPresetCells();
		Scanner scanner = new Scanner(System.in);
		System.out.println(gol.toString());
		String exit = "";
		
		while (!exit.equals("Exit")) {
			gol.setNewList(gol.live());
			System.out.println(gol.toString());
			exit = scanner.next();
		}
		
		scanner.close();
	}

}
