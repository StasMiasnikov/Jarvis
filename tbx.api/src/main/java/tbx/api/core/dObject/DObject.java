package tbx.api.core.dObject;





import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import tbx.api.core.dObject.property.JarvisDObjectProperty;


public class DObject
{
	String								name;
	long								id;
	Map<String,JarvisDObjectProperty>	properties;

	long								revision	= 0L;

	public DObject()
	{
		properties = new HashMap<>( );
	}

	public DObject( String name )
	{
		this.name = name;
	}

	public DObject( String name , int id )
	{
		this( name );
		this.id = id;
	}

	public DObject( int i )
	{
		// TODO Auto-generated constructor stub
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	public long getRevision()
	{
		return revision;
	}

	public void setRevision( long revision )
	{
		this.revision = revision;
	}

	public Map<String,JarvisDObjectProperty> getAllPropertiesUnmodifiable()
	{
		return Collections.unmodifiableMap( properties );
	}

	public void setAllProperties( Map<String,JarvisDObjectProperty> propertiesToSet )
	{
		this.properties = propertiesToSet;
	}

	public void addProperty( JarvisDObjectProperty baseDObjectProperty )
	{
		this.properties.put( String.valueOf( baseDObjectProperty.getId( ) ) , baseDObjectProperty );
		
	}

	public void addOrChangeProperty( JarvisDObjectProperty ... baseDObjectPropertyList )
	{
		for ( JarvisDObjectProperty baseDObjectProperty : baseDObjectPropertyList )
		{
			if ( this.properties.containsKey( baseDObjectProperty.getId( ) ) )
			{
				this.properties.remove( baseDObjectProperty.getId( ) );
			}
			this.properties.put( String.valueOf( baseDObjectProperty.getId( ) ) , baseDObjectProperty );
		}
		
	}

	public void removeProperty( JarvisDObjectProperty baseDObjectPropertyToRemove )
	{
		this.properties.remove( baseDObjectPropertyToRemove.getId( ) );
	}

	public JarvisDObjectProperty getPropertyByName( String name )
	{
		return this.properties.get( name );
	}

}
