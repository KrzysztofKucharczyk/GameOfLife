import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameOfLifeEngineTest {

	@Test
	public void should_return_list_of_living_cells_after_next_generation() {
		// given
		List<ILivingCell> testCells = new ArrayList<ILivingCell>();
		testCells.add(new LivingCell(1, 1));
		testCells.add(new LivingCell(1, 2));
		testCells.add(new LivingCell(1, 3));
		GameOfLifeEngine engine = new GameOfLifeEngine(testCells);

		// when
		List<ILivingCell> result = engine.checkCells();

		// then
		assertTrue(result.contains(new LivingCell(1, 2)));
	}
	
	@Test
	public void should_return_list_of_reproduced_cells_after_next_generation() {
		// given
		List<ILivingCell> testCells = new ArrayList<ILivingCell>();
		testCells.add(new LivingCell(1, 1));
		testCells.add(new LivingCell(1, 2));
		testCells.add(new LivingCell(1, 3));
		GameOfLifeEngine engine = new GameOfLifeEngine(testCells);

		// when
		List<ILivingCell> result = engine.reproduction();

		// then
		assertTrue(result.contains(new LivingCell(0, 2)));
		assertTrue(result.contains(new LivingCell(2, 2)));
	}

}
