package tbx.web.ui.impl.objects;





import java.util.ArrayList;
import java.util.List;


import tbx.api.core.dObject.DObject;
import tbx.api.core.dObject.property.JarvisDObjectProperty;


public class WebImplDObject extends DObject
{
	List<IUIDobjectChangeListener>	listeners;

	DObject							dObject;

	private WebImplDObject()
	{
	}

	public WebImplDObject( DObject dObject )
	{
		this( );
		this.dObject = dObject;
		this.listeners = new ArrayList<>( );
	}

	public final void addLIstener( IUIDobjectChangeListener iDobjectChangeListenerToAdd )
	{
		listeners.add( iDobjectChangeListenerToAdd );
	}

	public final void removeDobjectChangeListener( IUIDobjectChangeListener iDobjectChangeListenerToRemove )
	{
		try
		{
			listeners.remove( listeners.indexOf( iDobjectChangeListenerToRemove ) );
		}
		catch ( Exception ex )
		{
			ex.printStackTrace( );
		}
	}

	@Override
	public void addProperty( JarvisDObjectProperty baseDObjectProperty )
	{

		super.addProperty( baseDObjectProperty );
		notifyChange( );
	}

	@Override
	public void addOrChangeProperty( JarvisDObjectProperty ... baseDObjectPropertyList )
	{

		super.addOrChangeProperty( baseDObjectPropertyList );
		notifyChange( );
	}

	@Override
	public void removeProperty( JarvisDObjectProperty baseDObjectPropertyToRemove )
	{

		super.removeProperty( baseDObjectPropertyToRemove );
		notifyChange( );
	}

	private void notifyChange()
	{
		for ( IUIDobjectChangeListener listener : listeners )
		{
			listener.webUIdObjectChanged( this );
		}
	}
}
