package tbx.web.ui.main.page.ui;





import java.io.Serializable;


import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;


import tbx.api.core.dObject.DObject;
import tbx.web.ui.connectors.VaadinConnector;
import tbx.web.ui.factories.TBXUIFactory;
import tbx.web.ui.impl.objects.WebImplDObject;
import tbx.web.ui.windows.LoginWindow;
import tbx.web.ui.windows.LoginWindow.ILoginWindowCallback;


@Theme ( "valo" )
@Push
// @PreserveOnRefresh
public class MainPageUI extends UI implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	VaadinConnector				vaadinConnector;
	LoginWindow					loginwindow;
	WebImplDObject				userDetailsObject;
	TBXUIFactory				uiFactory;

	@Override
	protected void init( VaadinRequest request )
	{
		vaadinConnector = new VaadinConnector( this );
		uiFactory = new TBXUIFactory( vaadinConnector );
		initAndShowLoginWindow( );
	}

	private void handleUserLogin( DObject userDetails )
	{

		

	}

	private void initAndShowLoginWindow()
	{

		loginwindow = new LoginWindow( new ILoginWindowCallback( )
		{

			@Override
			public void logIn( WebImplDObject userDetails )
			{
				handleUserLogin( userDetails );

			}

			@Override
			public void createNewUser()
			{
				// TODO Auto-generated method stub

			}
		} , uiFactory );

		UI.getCurrent( ).addWindow( loginwindow );
	}
}
