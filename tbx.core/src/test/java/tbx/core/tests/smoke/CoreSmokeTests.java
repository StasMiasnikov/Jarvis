package tbx.core.tests.smoke;





import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import tbx.core.impl.CoreImpl;
import tbx.testing.base.BaseTBXTestClass;


public class CoreSmokeTests extends BaseTBXTestClass
{

	@Before
	public void start()
	{

	}

	@Test
	public void assertCoreStarted()
	{
		toolBoxCore = new CoreImpl( );
		Assert.assertNotNull( "ToolBoxCore should not be null" , toolBoxCore );
	}

	@After
	public void stop()
	{
		toolBoxCore = null;
	}
}
