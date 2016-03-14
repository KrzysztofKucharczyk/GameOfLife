import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputMethod implements IInputMethod {

	private Scanner fileReader;
	private Scanner userInput = new Scanner(System.in);

	public InputMethod() {
		fileReader = new Scanner(System.in);
	}

	public InputMethod(String filename) {
		try {
			fileReader = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot load file.\n");
		}
	}

	public List<ICell> getPresetCells() {
		int amountOfInputs = fileReader.nextInt();
		List<ICell> presetCells = new ArrayList<ICell>();

		for (int i = 0; i < amountOfInputs; i++) {
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
