package tbx.api.core.dObject.property;





import java.io.Serializable;


public class JarvisDObjectProperty implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	long						parentObjectId		= -1;
	String						name;
	private Object				value;
	long						id					= -1;

	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	public JarvisDObjectProperty()
	{
		value = new Object( );
	}

	public JarvisDObjectProperty( String name )
	{
		this.name = name;
	}

	public JarvisDObjectProperty( String name , Object value )
	{
		this.name = name;
		this.value = value;
	}

	public final void bind( ITBXBasePropertyChangedListener changedListener )
	{
		// listeners.add( changedListener );

	}

	public final Object getValue()
	{
		return value;
	}

	private void notifyAllListeners()
	{

	}

	public final void setValue( Object valueToSet )
	{
		this.value = valueToSet;
		notifyAllListeners( );

	}

	public void setValueBulk( Object valueToSet )
	{
		this.value = valueToSet;
	}

	public final void fireThisPropertyUpdated()
	{
		notifyAllListeners( );
	}

	public final void unBind( ITBXBasePropertyChangedListener changedListener )
	{
		// listeners.remove( changedListener );

	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public long getParentObjectId()
	{
		return parentObjectId;
	}

	public void setParentObjectId( long parentObjectId )
	{
		this.parentObjectId = parentObjectId;
	}

	public static final JarvisDObjectProperty createProp( String name , Object value )
	{
		return new JarvisDObjectProperty( name , value )
		{
		};
	}
}
