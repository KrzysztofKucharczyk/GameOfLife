import java.util.List;

public interface IInputMethod {
	public List<ICell> getPresetCells();
	public String getUserInput();
	public void closeInput();
}
