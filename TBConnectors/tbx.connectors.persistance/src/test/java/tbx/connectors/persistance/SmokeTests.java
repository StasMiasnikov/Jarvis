package tbx.connectors.persistance;





import org.junit.Test;


import tbx.api.core.connectors.ICoreBackendConnectorCallback;
import tbx.api.core.dObject.DObject;
import tbx.connectors.persistance.jdbc.HsqlConnector;


public class SmokeTests
{

	@Test
	public void checkDBIsLoading()
	{
		HsqlConnector hsqlConnector = new HsqlConnector( );

		hsqlConnector.addQueryReturnCallback( new ICoreBackendConnectorCallback( )
		{

			@Override
			public void queryReturned( DObject dObject )
			{
				// TODO Auto-generated method stub

			}
		} );
		
		
		

		
	}

}
