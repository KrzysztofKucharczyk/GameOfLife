import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputMethod implements IInputMethod<Integer> {

	private final Scanner sourceReader;

	public InputMethod(String[] args) throws FileNotFoundException {
		if (args.length == 1)
			sourceReader = setFileAsSource(args[0]);
		else
			sourceReader = setStdIOAsSource();
	}

	private Scanner setFileAsSource(String filename) throws FileNotFoundException {
			return new Scanner(new File(filename));
	}
	
	private Scanner setStdIOAsSource() {
		return new Scanner(System.in);
	}

	public Integer getInput() {
		return sourceReader.nextInt();
	}

	public void closeInput() {
		sourceReader.close();
	}
}
