import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

	private List<ICell> cells = new ArrayList<ICell>();

	public void setNewList(List<ICell> cells) {
		this.cells = cells;
	}

	public List<ICell> live() {
		IEngine engine = new GameOfLifeEngine(cells);
		List<ICell> newList = new ArrayList<ICell>();

		for (ICell cell : cells) {
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
		
		IInputMethod input;

		if(args.length == 1)
			input = new InputMethod(args[0]);
		else
			input = new InputMethod();
		
		String exit = "";

		gol.setNewList(input.getPresetCells());
		System.out.println(gol.toString());

		while (!exit.equals("Exit")) {
			gol.setNewList(gol.live());
			System.out.println(gol.toString());
			exit = input.getUserInput();
		}
		input.closeInput();
	}
}
