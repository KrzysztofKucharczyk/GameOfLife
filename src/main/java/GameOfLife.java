import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GameOfLife implements IGameOfLife{
	private List<ICell> livingCells = new ArrayList<ICell>();

	public void setNewList(List<ICell> cells) {
		this.livingCells = cells;
		if(livingCells.isEmpty())
			System.out.print("No more living cells.\n");
	}

	public List<ICell> getLivingCells() {
		return livingCells;
	}

	public List<ICell> live() {
		IEngine engine = new GameOfLifeEngine(livingCells);

		// Checks if living cells will continue to live
		 List<ICell> newList = engine.checkLivingCells();
		// Finds new cells reproduced by 3 nearby cells
		newList.addAll(engine.reproduction());

		return newList;
	}

	public List<ICell> getPresetCells(IInputMethod<Integer> sourceDataReader) {
		int amountOfInputData = sourceDataReader.getInput();
		List<ICell> presetCells = new ArrayList<ICell>();

		for (int i = 0; i < amountOfInputData; i++) {
			int x = sourceDataReader.getInput();
			int y = sourceDataReader.getInput();
			presetCells.add(new Cell(x, y));
		}

		return presetCells;
	}

	public static void main(String[] args) throws FileNotFoundException {
		GameOfLife gol = new GameOfLife();
		IInputMethod<Integer> sourceReader = new SourceDataReader(args);
		IInputMethod<String> userInput = new UserInputReader();
		IDisplayer gameOfLifeDisplayer;
		gol.setNewList(gol.getPresetCells(sourceReader));
		gameOfLifeDisplayer = new Displayer(gol.getLivingCells());

		do {
			gameOfLifeDisplayer.display();
			gol.setNewList(gol.live());
			gameOfLifeDisplayer.setNewCellsList(gol.getLivingCells());
		} while (!(userInput.getInput().equals("q") || (gol.getLivingCells().isEmpty())));

		sourceReader.closeInput();
		userInput.closeInput();
	}
}
