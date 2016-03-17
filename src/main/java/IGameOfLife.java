import java.util.List;

public interface IGameOfLife {
	public void setNewCellsList(List<ILivingCell> cells);
	public List<ILivingCell> getCells();
	public List<ILivingCell> live();
	public List<ILivingCell> getPresetCells(IInputMethod<Integer> sourceDataReader);
}
