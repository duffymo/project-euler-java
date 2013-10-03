package euler;

import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;

/**
 * EulerProblemTest; base class that times each test
 * User: MOD
 * Date: Oct 11, 2008
 * Time: 10:51:28 PM
 */
public class TimedTest extends TestCase
{
   protected static final Log LOGGER = LogFactory.getLog(TimedTest.class);

   private long begTime;
   private long endTime;

   @Before
   public void setUp()
   {
      this.begTime = System.currentTimeMillis();
      this.endTime = 0L;
   }

   @After
   public void tearDown()
   {
      this.endTime = System.currentTimeMillis();
      LOGGER.info("test name: " + this.getName());
      LOGGER.info(" wall time: " + (endTime-begTime) + " msec");
   }
}
