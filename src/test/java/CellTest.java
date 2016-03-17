import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void should_return_false_when_compared_to_equal() {
		// given
		ILivingCell testCell = new LivingCell(0, 0);

		// when
		boolean result = testCell.equals(null);

		// then
		assertTrue(result == false);
	}

	@Test
	public void should_return_false_when_compared_to_unequal_cell() {
		// given
		ILivingCell testCell = new LivingCell(0, 0);
		ILivingCell otherCell = new LivingCell(1, 10);
		
		// when
		boolean result = testCell.equals(otherCell);

		// then
		assertTrue(result == false);
	}
	
	@Test
	public void should_return_true_when_compared_to_equal_cell() {
		// given
		ILivingCell testCell = new LivingCell(0, 0);
		ILivingCell otherCell = new LivingCell(0, 0);
		
		// when
		boolean result = testCell.equals(otherCell);

		// then
		assertTrue(result == true);
	}
	
	@Test
	public void should_return_valid_string_representation_of_cell() {
		// given
				ILivingCell testCell = new LivingCell(10, 20);
				
				// when
				String result = testCell.toString();

				// then
				assertTrue(result.equals("(x: 10, y: 20)"));
	}
}
