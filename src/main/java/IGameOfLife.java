import java.util.List;

public interface IGameOfLife {
	public void setNewList(List<ICell> cells);
	public List<ICell> getLivingCells();
	public List<ICell> live();
	public List<ICell> getPresetCells(IInputMethod<Integer> sourceDataReader);
}
