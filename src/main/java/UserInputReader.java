import java.util.Scanner;

public class UserInputReader implements IInputMethod<String>{
	private final Scanner userInput = new Scanner(System.in);
	
	public String getInput() {
		System.out.print("Press any key to progress one generation (q to exit)... ");
		return userInput.hasNext() ? new String(userInput.next()) : "q";
	}

	public void closeInput() {
		userInput.close();
	}

	public boolean hasNext() {
		return userInput.hasNext();
	}
}
