package belajar.servlet;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.selenium.SeleneseTestCase;

public class HaloServletTestIT extends SeleneseTestCase {
	private static final int PORT = 9090;
	private static final String CONTEXT_ROOT = "/belajar";

	/** Used in all integration tests. */
	  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	  @Before
	  public void setUp() throws Exception {
	    setUp("http://localhost:" + PORT + CONTEXT_ROOT, "*firefox");
	  }

	  @Test
	  public void testHello() {
		  selenium.open("http://localhost:" + PORT + CONTEXT_ROOT+"/halo");
		  selenium.waitForPageToLoad("30000");
		  assertTrue("Halo Servlet tidak ada",selenium.isTextPresent("Halo Servlet"));
	  }


}
