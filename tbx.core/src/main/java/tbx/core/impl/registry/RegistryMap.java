package tbx.core.impl.registry;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


import tbx.api.core.connectors.ICoreBackendConnectorCallback;
import tbx.api.core.connectors.IRegistryBackendConnector;
import tbx.api.core.connectors.IRegistryConnector;
import tbx.api.core.dObject.DObject;
import tbx.api.core.dObject.IDObjectChangeNotification;


public class RegistryMap implements ICoreBackendConnectorCallback
{

	private int												nextId							= 1;
	private LinkedBlockingQueue<IDObjectChangeNotification>	incoming						= new LinkedBlockingQueue<>( );
	private LinkedBlockingQueue<IDObjectChangeNotification>	outgoing						= new LinkedBlockingQueue<>( );

	final ExecutorService									executor						= Executors.newFixedThreadPool( 2 );

	Runnable												incomingListener;
	Runnable												outgoingListener;

	// TODO probably rename to RegistryDobject
	Map<Long,DObject>										objects							= new HashMap<>( );
	public Map<Long,List<IRegistryConnector>>				objectListeners					= new HashMap<>( );
	public List<IRegistryConnector>							connectedExternalConnectors		= new ArrayList<>( );
	public List<IRegistryBackendConnector>					connectedPersistanceConnectors	= new ArrayList<>( );

	// TODO
	public List<Object>										somethingWithQuery				= new ArrayList<>( );

	public RegistryMap()
	{
		// TODO start incoming and outgoing threads
	}

	private void processPersistanceAndOutgoingObjectChange( DObject dObjectToUpdate )
	{

		// Persist object
		System.out.println( "STOP" );
		// connectedPersistanceConnectors.get( 0 ).updateDObject( dObjectToUpdate );
		if ( !objects.containsKey( dObjectToUpdate.getId( ) ) )
		{
			// objects.put( dObjectToUpdate.id , dObjectToUpdate );
			return;
		}
		// TODO here actual object data change//FIXME
		objects.get( dObjectToUpdate.getId( ) );// .updateFrom( dObjectToUpdate );

		// Notify connectors
		if ( objectListeners.get( dObjectToUpdate.getId( ) ) != null )
		{
			try
			{
				outgoing.put( new IDObjectChangeNotification( )
				{

					@Override
					public DObject getDobject()
					{

						return dObjectToUpdate;
					}

				} );
			}
			catch ( Exception ex )
			{
				ex.printStackTrace( );// TODO
			}

		}
		else
		{
			// IF no connectors are listening to this object , remove it from the list.
		}

	}

	// Get outside
	public void processIncomingChangeNotification( DObject dObject )
	{
		try
		{
			incoming.put( new IDObjectChangeNotification( )
			{

				@Override
				public DObject getDobject()
				{
					// TODO Auto-generated method stub
					return dObject;
				}
			} );
		}
		catch ( InterruptedException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}
	}

	public RegistryMap start()
	{
		return this;

	}

	public void stop()
	{
		// TODO Auto-generated method stub

	}

	public boolean addConnector( IRegistryConnector connector )
	{

		if ( connector instanceof ICoreBackendConnectorCallback )
		{
			connectedExternalConnectors.add( connector );
		}
		else
		{
			connectedPersistanceConnectors.add( ( IRegistryBackendConnector ) connector );
		}
		return true;
	}

	public boolean removeConnector( IRegistryConnector connector )
	{
		try
		{
			connectedExternalConnectors.remove( connectedExternalConnectors.indexOf( connector ) );
		}
		catch ( Exception ex )
		{
			ex.printStackTrace( );// TODO
		}
		return false;
	}

	@Override
	public void queryReturned( DObject dObject )
	{
		long objectID = dObject.getId( );
		List<IRegistryConnector> registeredObjectListeners = objectListeners.get( objectID );

		// TODO notify listeners for change
	}

	public List<IRegistryConnector> getAllConnectors()
	{
		return connectedExternalConnectors;
	}

}
