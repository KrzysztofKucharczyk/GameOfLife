import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputMethod implements IInputMethod {

	private final Scanner fileReader;
	private final Scanner userInput = new Scanner(System.in);

	public InputMethod(String[] args) throws FileNotFoundException {
		if (args.length == 1)
			fileReader = setFileAsSource(args[0]);
		else
			fileReader = setStdIOAsSource();
	}

	private Scanner setFileAsSource(String filename) throws FileNotFoundException {
			return new Scanner(new File(filename));
	}
	
	private Scanner setStdIOAsSource() {
		return new Scanner(System.in);
	}

	public List<ICell> getPresetCells() {
		int amountOfInputData = fileReader.nextInt();
		List<ICell> presetCells = new ArrayList<ICell>();

		for (int i = 0; i < amountOfInputData; i++) {
			int x = fileReader.nextInt();
			int y = fileReader.nextInt();
			presetCells.add(new Cell(x, y));
		}

		return presetCells;
	}

	public String getUserInput() {
		return userInput.hasNext() ? new String(userInput.next()) : "Exit";
	}

	public void closeInput() {
		fileReader.close();
		userInput.close();
	}
}
