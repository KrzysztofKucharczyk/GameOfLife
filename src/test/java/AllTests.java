import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CellTest.class, GameOfLifeTest.class, GameOfLifeEngineTest.class })
public class AllTests {

}
