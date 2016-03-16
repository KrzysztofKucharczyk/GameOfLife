import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	private List<ICell> livingCells = new ArrayList<ICell>();

	public void setNewList(List<ICell> cells) {
		this.livingCells = cells;
		if(livingCells.isEmpty())
			System.out.println("No more living cells.");
	}

	public List<ICell> getLivingCells() {
		return livingCells;
	}

	public List<ICell> live() {
		IEngine engine = new GameOfLifeEngine(livingCells);
		List<ICell> newList = new ArrayList<ICell>();

		// Checks if living cells will continue to live
		newList.addAll(engine.checkLivingCells());
		// Finds new cells reproduced by 3 nearby cells
		newList.addAll(engine.reproduction());

		return newList;
	}

	public List<ICell> getPresetCells(IInputMethod<Integer> fileReader) {
		int amountOfInputData = fileReader.getInput();
		List<ICell> presetCells = new ArrayList<ICell>();

		for (int i = 0; i < amountOfInputData; i++) {
			int x = fileReader.getInput();
			int y = fileReader.getInput();
			presetCells.add(new Cell(x, y));
		}

		return presetCells;
	}

	public static void main(String[] args) throws FileNotFoundException {
		GameOfLife gol = new GameOfLife();
		IInputMethod<Integer> sourceReader = new InputMethod(args);
		IInputMethod<String> userInput = new UserInput();
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
