package tbx.core.impl;





import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.logging.Logger;


import tbx.api.core.connectors.IRegistryConnector;
import tbx.api.core.dObject.DObject;
import tbx.api.core.main.IToolBoxCore;
import tbx.core.impl.osgi.JarvisOSGIWrapper;
import tbx.core.impl.registry.RegistryMap;


public class CoreImpl implements IToolBoxCore
{

	JarvisOSGIWrapper	osgiWrapper;
	RegistryMap			registryMap;

	// List<ICoreConnector> connectors;

	public CoreImpl()
	{

		try
		{
			Logger.getAnonymousLogger( ).info( "Start  loading classpath connectors " );
			Iterator<IRegistryConnector> connectorIterator = ServiceLoader.load( IRegistryConnector.class ).iterator( );
			Logger.getAnonymousLogger( ).info( "Connectors loaded :" );
			while ( connectorIterator.hasNext( ) )
			{
				IRegistryConnector iConnector = connectorIterator.next( );
				addConnector( iConnector );

				Logger.getAnonymousLogger( ).info( "Loaded classpath connector : " + iConnector.getName( ) );

			}

		}
		catch ( Exception ex )
		{
			ex.printStackTrace( );
		}
	}

	@Override
	public void stop()
	{
		Logger.getAnonymousLogger( ).info( "Stopping core" );
		osgiWrapper.stop( );
		registryMap.stop( );

	}

	@Override
	public void start()
	{
		Logger.getAnonymousLogger( ).info( "Starting core" );
		osgiWrapper = new JarvisOSGIWrapper( ).start( );
		registryMap = new RegistryMap( ).start( );

	}

	@Override
	public boolean addConnector( IRegistryConnector connector )
	{
		registryMap.addConnector( connector );

		return true;
	}

	@Override
	public boolean removeConnector( IRegistryConnector connector )
	{

		registryMap.removeConnector( connector );

		return false;
	}

	@Override
	public boolean canStart()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void updateDobject( DObject dObjectTUpdate )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<IRegistryConnector> getAllConnectorsUnmodifiable()
	{
		List<IRegistryConnector> connectors = registryMap.getAllConnectors( );
		return Collections.unmodifiableList( connectors );
	}

}
