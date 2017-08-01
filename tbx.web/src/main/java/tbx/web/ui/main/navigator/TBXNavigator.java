package tbx.web.ui.main.navigator;





import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;


public class TBXNavigator extends UI
{

	Navigator					navigator;
	private static final long	serialVersionUID	= 1L;

	@Override
	protected void init( VaadinRequest request )
	{
		setResponsive( true );
		navigator = new Navigator( this , this );
		//navigator.addView( "Login" , new LoginPageUI( ) );
		navigator.navigateTo( "Login" );
	}

}
