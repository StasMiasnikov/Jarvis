package tbx.web.ui.component.wrappers;





import tbx.web.ui.property.BaseToolBoxUIProperty;
import tbx.web.ui.property.listeners.IToolBoxUIPropertyChangedListener;
import tbx.web.ui.property.types.StringToolBoxUIProperty;


import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;


public class TBXButton extends Button
{

	private static final long serialVersionUID = 1L;

	public BaseToolBoxUIProperty<String>	buttonTextProperty	= new StringToolBoxUIProperty( );
	public BaseToolBoxUIProperty<String>	iconProperty		= new StringToolBoxUIProperty( );
	public BaseToolBoxUIProperty<String>	toolTipUIProperty	= new StringToolBoxUIProperty( );

	public TBXButton()
	{
		super( );

		buttonTextProperty.bind( new IToolBoxUIPropertyChangedListener<String>( )
		{

			@Override
			public void notifyPropertyChanged( String newProperty )
			{
				setCaption( newProperty.toString( ) );

			}
		} );

		iconProperty.bind( new IToolBoxUIPropertyChangedListener<String>( )
		{

			@Override
			public void notifyPropertyChanged( String newProperty )
			{

				try
				{
					setIcon( FontAwesome.valueOf( newProperty.toString( ) ) );
				}
				catch ( Exception ex )
				{
					ex.printStackTrace( );// TODO
				}
			}
		} );
	}

	public TBXButton(String caption)
	{this();
		buttonTextProperty.setValue( caption );
		
		
	}
}
