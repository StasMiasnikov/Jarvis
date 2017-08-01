package tbx.web.ui.testables.dragdrop;





import java.util.logging.Logger;


import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class DragAndDropTesting extends VerticalLayout
{

	private static final long	serialVersionUID	= 1L;

	VerticalLayout				fromLayout;
	VerticalLayout				toLayout;

	public DragAndDropTesting()
	{
		fromLayout = new VerticalLayout( );
		fromLayout.setSizeFull( );
		toLayout = new VerticalLayout( );
		toLayout.setSizeFull( );
		toLayout.addComponent( new Label( "asdasdasdasdasdasdasdadasdasdasdasda" ) );
		DragAndDropWrapper dragAndDropWrapper = new DragAndDropWrapper( toLayout );
		dragAndDropWrapper.setDropHandler( new DropHandler( )
		{

			@Override
			public AcceptCriterion getAcceptCriterion()
			{
				// TODO Auto-generated method stub
				return AcceptAll.get( );
			}

			@Override
			public void drop( DragAndDropEvent event )
			{
				Logger.getAnonymousLogger( ).info( event.toString( ) );

			}
		} );
		addComponent( fromLayout );
		addComponent( dragAndDropWrapper );

		for ( int c = 0 ; c < 3 ; c++ )
		{
			DragAndDropWrapper buttonWrapper = new DragAndDropWrapper( new Button( String.valueOf( c ) ) );
			buttonWrapper.setDragStartMode( DragStartMode.COMPONENT );

			fromLayout.addComponent( buttonWrapper );
		}

		Label tableLabel = new Label( "Table" );
		tableLabel.setIcon( FontAwesome.TABLE );

		DragAndDropWrapper labelTableWrapper = new DragAndDropWrapper( tableLabel );
		labelTableWrapper.setDragStartMode( DragStartMode.COMPONENT );
		labelTableWrapper.setIcon( FontAwesome.TABLE );
		fromLayout.addComponent( labelTableWrapper );
	}

}
