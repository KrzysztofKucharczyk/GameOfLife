import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameOfLifeEngineTest {

	@Test
	public void should_return_list_of_living_cells_after_next_generation() {
		// given
		List<ICell> testCells = new ArrayList<ICell>();
		testCells.add(new Cell(1, 1));
		testCells.add(new Cell(1, 2));
		testCells.add(new Cell(1, 3));
		GameOfLifeEngine engine = new GameOfLifeEngine(testCells);

		// when
		List<ICell> result = engine.checkLivingCells();

		// then
		assertTrue(result.contains(new Cell(1, 2)));
	}
	
	@Test
	public void should_return_list_of_reproduced_cells_after_next_generation() {
		// given
		List<ICell> testCells = new ArrayList<ICell>();
		testCells.add(new Cell(1, 1));
		testCells.add(new Cell(1, 2));
		testCells.add(new Cell(1, 3));
		GameOfLifeEngine engine = new GameOfLifeEngine(testCells);

		// when
		List<ICell> result = engine.reproduction();

		// then
		assertTrue(result.contains(new Cell(0, 2)));
		assertTrue(result.contains(new Cell(2, 2)));
	}

}
