package scripts.mocktest2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ britannica.class, imdb.class, ShoppersStop.class })
public class AllTests {

}
