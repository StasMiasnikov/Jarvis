package tbx.web.tests.smoke;





import java.util.List;
import java.util.ServiceLoader;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import tbx.api.core.connectors.IRegistryConnector;
import tbx.api.core.main.IToolBoxCore;
import tbx.testing.base.BaseTBXTestClass;
import tbx.web.ui.connectors.VaadinConnector;


public class WebSmokeTests extends BaseTBXTestClass
{
	@BeforeClass
	public static void beforeClass()
	{
	}

	@Before
	public void start()
	{
		toolBoxCore = null;

		toolBoxCore = ( IToolBoxCore ) ServiceLoader.load( IToolBoxCore.class ).iterator( ).next( );
	}

	@Test
	public void assertCoreStarted()
	{

		Assert.assertNotNull( "ToolBoxCore should not be null" , toolBoxCore );

	}

	//@Test 
	public void checkVaadinConnectorWasLoaded()
	{
		List<IRegistryConnector> allCoreConnectors = toolBoxCore.getAllConnectorsUnmodifiable( );
		boolean wasConnectorFound = false;
		VaadinConnector vaadinConnector = new VaadinConnector( );
		for ( IRegistryConnector connector : allCoreConnectors )
		{
			if ( connector.getName( ).equals( vaadinConnector.getName( ) ) )
			{
				wasConnectorFound = true;
				break;
			}
		}

		Assert.assertTrue( "Vaadin connector should be loaded with the WebModule" , wasConnectorFound );
	}

	@After
	public void stop()
	{
		toolBoxCore = null;
	}
}
