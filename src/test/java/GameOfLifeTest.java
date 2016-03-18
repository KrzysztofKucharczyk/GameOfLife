import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void should_set_new_list_and_inform_it_is_empty() {
		// given 
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		GameOfLife gameOfLife = new GameOfLife();
		List<ILivingCell> testList = new ArrayList<ILivingCell>();
		
		// when
		gameOfLife.setNewCellsList(testList);
		
		// then
		assertEquals("No more living cells.\n", outContent.toString());
	}
	
	@Test
	public void should_set_new_list() {
		// given 
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		GameOfLife gameOfLife = new GameOfLife();
		List<ILivingCell> testList = new ArrayList<ILivingCell>();
		testList.add(new LivingCell(10, 11));
		
		// when
		gameOfLife.setNewCellsList(testList);
		
		// then
		assertEquals(10, testList.get(0).getX());
		assertEquals(11, testList.get(0).getY());
	}
	
	@Test
	public void should_get_list_of_preset_cells_from_stdin() throws FileNotFoundException {
		// given
		ByteArrayInputStream in = new ByteArrayInputStream("1 1\n2 2".getBytes());
		System.setIn(in);
		GameOfLife gameOfLife = new GameOfLife();
		String[] args = new String[0];
		IInputMethod<Integer> testSourceReader = new SourceDataReader(args);
		
		// when
		List<ILivingCell> result = gameOfLife.getPresetCells(testSourceReader);
		
		// then 
		assertTrue(result.get(0).equals(new LivingCell(1, 1)));
		assertTrue(result.get(1).equals(new LivingCell(2, 2)));	
	}
	
	@Test
	public void should_get_list_of_preset_cells_from_file() throws FileNotFoundException {
		// given
		ByteArrayInputStream in = new ByteArrayInputStream("2\n1 1\n2 2".getBytes());
		System.setIn(in);
		GameOfLife gameOfLife = new GameOfLife();
		String[] args = new String[1];
		args[0] = "testData/presetCellsTest.txt";
		IInputMethod<Integer> testSourceReader = new SourceDataReader(args);
		
		// when
		List<ILivingCell> result = gameOfLife.getPresetCells(testSourceReader);
		
		// then 
		assertTrue(result.get(0).equals(new LivingCell(1, 3)));
		assertTrue(result.get(1).equals(new LivingCell(1, 5)));
		assertTrue(result.get(2).equals(new LivingCell(2, 3)));
		assertTrue(result.get(3).equals(new LivingCell(2, 5)));	
	}
	
	@Test
	public void should_return_empty_list_of_living_cells() {
		// given
		GameOfLife gameOfLife = new GameOfLife();
		List<ILivingCell> cells = new ArrayList<ILivingCell>();
		cells.add(new LivingCell(10, 10));
		cells.add(new LivingCell(10, 11));
		gameOfLife.setNewCellsList(cells);
		
		// when
		List<ILivingCell> result = gameOfLife.live();
		
		// then 
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void should_return_list_of_living_cells() {
		// given
		GameOfLife gameOfLife = new GameOfLife();
		List<ILivingCell> cells = new ArrayList<ILivingCell>();
		cells.add(new LivingCell(10, 10));
		cells.add(new LivingCell(10, 11));
		cells.add(new LivingCell(10, 12));
		gameOfLife.setNewCellsList(cells);
		
		// when
		List<ILivingCell> result = gameOfLife.live();
		
		// then 
		assertTrue(result.contains(new LivingCell(9,11)));
		assertTrue(result.contains(new LivingCell(11,11)));
		assertTrue(result.contains(new LivingCell(10,11)));
	}
}
