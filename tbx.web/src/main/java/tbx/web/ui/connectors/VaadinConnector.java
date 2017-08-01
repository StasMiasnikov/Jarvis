package tbx.web.ui.connectors;





import java.util.HashMap;
import java.util.Map;


import com.vaadin.ui.UI;


import tbx.api.core.connectors.IRegistryConnector;
import tbx.api.core.dObject.DObject;
import tbx.api.core.main.IToolBoxCore;
import tbx.web.context.ContextListener;
import tbx.web.ui.impl.objects.IUIDobjectChangeListener;
import tbx.web.ui.impl.objects.WebImplDObject;


public class VaadinConnector implements IRegistryConnector,IUIDobjectChangeListener
{
	UI						ui;
	IToolBoxCore			iToolBoxCore	= ContextListener.core;	// TODO

	Map<Integer,DObject>	dobjects		= new HashMap<>( );

	// asdasdsad
	public VaadinConnector()
	{
	}

	public VaadinConnector( UI ui )
	{
		this( );
		this.ui = ui;

	}

	@Override
	public void webUIdObjectChanged( WebImplDObject ref )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getName()
	{

		return "VaadinConnector";
	}

}

/*
 * 
 * 
 * 
 * IToolBoxCore core = ContextListener.core; Map<Integer,Property> props = new HashMap<>( ); UI ui; Map<Integer,Container> uiProperties = new HashMap<>( );
 * 
 * Map<Double,BaseToolBoxUIProperty> properties = new HashMap<>( );
 * 
 * private VaadinConnector() {
 * 
 * }
 * 
 * public VaadinConnector( UI ui ) { this( ); this.ui = ui; }
 * 
 * public void addContainer( Container containertoAdd ) { uiProperties.put( 123 , containertoAdd ); }
 * 
 * public void addProperty( DObject dObject , Property prop ) { props.put( dObject.getId( ) , prop ); }
 * 
 * @Override public void createDObject( DObject objectToCreate ) { core.getInputStream( ).createDobject( this , objectToCreate );
 * 
 * }
 * 
 * @Override public DObject executeQuery( DObject queryObject ) { return null; // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public String getName() { return Thread.currentThread( ).getName( ); }
 * 
 * @Override public void objectChanged( final IDObjectChangeNotification changeNotification ) { if ( !ui.isAttached( ) ) { Logger.getAnonymousLogger( ).info( "DETaCHED UI  FOUND " ); return; // TODO this is WA } ui.access( new Runnable( ) {
 * 
 * @Override public void run() {
 * 
 * } } );
 * 
 * // Logger.getAnonymousLogger( ).info( "Connector:" + getName( ) + " changing object " + changeNotification.getDobject( ).id ); }
 * 
 * @Override public void updateDObject( DObject dObject ) { core.getInputStream( ).updateDobject( this , dObject );
 * 
 * }
 * 
 * // @Override public void watchDObject( DObject dObject ) { core.getInputStream( ).watchDobject( this , dObject );
 * 
 * }
 * 
 * // @Override public void watchDObject( int dObjectID ) { core.getInputStream( ).watchDobject( this , new DObject( dObjectID ) );
 * 
 * }
 */
