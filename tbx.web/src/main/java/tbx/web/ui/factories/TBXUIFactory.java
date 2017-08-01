package tbx.web.ui.factories;





import java.util.List;


import tbx.api.core.dObject.DObject;
import tbx.api.core.dObject.property.JarvisDObjectProperty;
import tbx.web.ui.connectors.VaadinConnector;
import tbx.web.ui.impl.objects.WebImplDObject;
import tbx.web.ui.login.screen.TBXLoginScreen;
import tbx.web.ui.login.screen.TBXLoginScreen.ITBXLoginScreenActionCallback;
import tbx.web.ui.screens.base.ITBXBoundedScreen;
import tbx.web.ui.screens.main.JarvisMainScreen;


public class TBXUIFactory
{
	VaadinConnector vaadinConnector;

	public TBXUIFactory( VaadinConnector vaadinConnector )
	{
		this.vaadinConnector = vaadinConnector;
	}

	public TBXLoginScreen createLoginUserScreen( ITBXLoginScreenActionCallback loginScreenActionCallback )
	{
		TBXLoginScreen tbxLoginScreen = new TBXLoginScreen( "" , loginScreenActionCallback );
		WebImplDObject userDetailsObject = new WebImplDObject( new DObject( ) );

		userDetailsObject.addProperty( new JarvisDObjectProperty( "UserName" )
		{
		} );
		userDetailsObject.addProperty( new JarvisDObjectProperty( "Password" )
		{
		} );
		userDetailsObject.addLIstener( vaadinConnector );
		tbxLoginScreen.setBoundedObject( userDetailsObject );
		return tbxLoginScreen;
	}

	public ITBXBoundedScreen getMainScreen(WebImplDObject user)
	{
		
		JarvisDObjectProperty  userScreens = user.getPropertyByName( "UserScreens" );
		List<String> listOfScreens = ( List<String> ) userScreens.getValue( );
		JarvisMainScreen jarvisMainScreen = new JarvisMainScreen( );
		jarvisMainScreen.setBoundedObject( user );
		
		
		return null;
	}
	
	private ITBXBoundedScreen getDashBoardScreen(WebImplDObject dObject)
	{
		return null;
	}
	
}
