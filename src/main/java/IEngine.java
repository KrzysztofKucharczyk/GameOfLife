import java.util.List;

public interface IEngine {
	public int getNeighbourhood(ICell cell);
	public List<ICell> reproduction();
}
  