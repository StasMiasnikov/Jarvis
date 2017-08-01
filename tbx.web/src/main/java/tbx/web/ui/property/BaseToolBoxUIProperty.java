package tbx.web.ui.property;





import java.util.ArrayList;
import java.util.List;


import tbx.web.ui.property.listeners.IToolBoxUIPropertyChangedListener;


import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.ObjectProperty;


@SuppressWarnings (
{ "unchecked" , "rawtypes" } )
public abstract class BaseToolBoxUIProperty<T>
{

	private List<ObjectProperty<Object>>	boundedObjectProperties	= new ArrayList<>( );
	private List<BaseToolBoxUIProperty>		boundedProperties		= new ArrayList<>( );

	private List<IToolBoxUIPropertyChangedListener>	listeners	= new ArrayList<>( );
	private T										value;

	public BaseToolBoxUIProperty()
	{
		value = ( T ) getValueRef( );
	}

	public final void bind( Property property )
	{

	}

	public final void bind( BaseToolBoxUIProperty iToolBoxUIProperty )
	{
		boundedProperties.add( iToolBoxUIProperty );

	}

	public final void bind( IToolBoxUIPropertyChangedListener<T> changedListener )
	{
		listeners.add( changedListener );

	}

	public final void bind( ObjectProperty<Object> objectPropertyToBindTo )
	{
		boundedObjectProperties.add( objectPropertyToBindTo );
		objectPropertyToBindTo.addValueChangeListener( new ValueChangeListener( )
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange( ValueChangeEvent event )
			{

				notifyAllListenersExcept( event.getProperty( ).getValue( ) , null );
				notifyAllObjectsExcept( event.getProperty( ).getValue( ) , objectPropertyToBindTo );
				notifyAllToolBoxPropertiesExcept( event.getProperty( ).getValue( ) , null );

			}
		} );

	}

	public final T getValue()
	{
		return value;
	}

	protected abstract Object getValueRef();

	private void notifyAllListenersExcept( Object valueToSet , IToolBoxUIPropertyChangedListener<T> changedListenerToIgnoreUpdate )
	{

		for ( IToolBoxUIPropertyChangedListener listener : listeners )
		{
			if ( changedListenerToIgnoreUpdate != listener )
			{
				listener.notifyPropertyChanged( valueToSet );
			}
		}
	}

	private void notifyAllObjectsExcept( Object valueToSet , ObjectProperty objectPropertyToIgnoreUpdate )
	{

		for ( ObjectProperty<Object> objectProperty : boundedObjectProperties )
		{
			if ( objectProperty != objectPropertyToIgnoreUpdate )
			{
				objectProperty.setValue( valueToSet );
			}

		}
	}

	private void notifyAllToolBoxPropertiesExcept( Object valueToSet , BaseToolBoxUIProperty iToolBoxUIPropertyToIgnoreUpdate )
	{

		for ( BaseToolBoxUIProperty property : boundedProperties )
		{
			if ( iToolBoxUIPropertyToIgnoreUpdate != property )
			{
				property.setValue( valueToSet );
			}
		}
	}

	public final void setValue( T valueToSet )
	{
		this.value = ( T ) valueToSet;
		notifyAllListenersExcept( valueToSet , null );
		notifyAllObjectsExcept( valueToSet , null );
		notifyAllToolBoxPropertiesExcept( valueToSet , null );
	}

	public final void unBind( BaseToolBoxUIProperty iToolBoxUIProperty )
	{
		boundedProperties.remove( iToolBoxUIProperty );

	}

	public final void unBind( IToolBoxUIPropertyChangedListener changedListener )
	{
		listeners.remove( changedListener );

	}

	public final void unBind( ObjectProperty<Object> objectPropertyToBindTo )
	{
		boundedObjectProperties.remove( objectPropertyToBindTo );

	}

}
