import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GameOfLife implements IGameOfLife{
	private List<ILivingCell> cells = new ArrayList<ILivingCell>();

	public void setNewCellsList(List<ILivingCell> cells) {
		this.cells = cells;
		if(cells.isEmpty())
			System.out.print("No more living cells.\n");
	}

	public List<ILivingCell> getCells() {
		return cells;
	}

	public List<ILivingCell> live() {
		IEngine engine = new GameOfLifeEngine(cells);

		// Checks if living cells will continue to live
		 List<ILivingCell> newCellsList = engine.checkCells();
		// Finds new cells reproduced by 3 nearby cells
		newCellsList.addAll(engine.reproduction());

		return newCellsList;
	}

	public List<ILivingCell> getPresetCells(IInputMethod<Integer> sourceDataReader) {
		List<ILivingCell> presetCells = new ArrayList<ILivingCell>();

		while (sourceDataReader.hasNext()) {
			int x = sourceDataReader.getInput();
			int y = sourceDataReader.getInput();
			presetCells.add(new LivingCell(x, y));
		}

		return presetCells;
	}

	public static void main(String[] args) throws FileNotFoundException {
		GameOfLife gol = new GameOfLife();
		IInputMethod<Integer> sourceReader = new SourceDataReader(args);
		IInputMethod<String> userInput = new UserInputReader();
		IDisplayer gameOfLifeDisplayer;
		gol.setNewCellsList(gol.getPresetCells(sourceReader));
		gameOfLifeDisplayer = new Displayer(gol.getCells());

		do {
			gameOfLifeDisplayer.display();
			gol.setNewCellsList(gol.live());
			gameOfLifeDisplayer.setNewCellsList(gol.getCells());
		} while (!(userInput.getInput().equals("q") || (gol.getCells().isEmpty())));

		sourceReader.closeInput();
		userInput.closeInput();
	}
}
