package tbx.web.ui.windows;





import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Window;


import tbx.web.ui.factories.TBXUIFactory;
import tbx.web.ui.framework.TBXWaitingIndicatorComponent;
import tbx.web.ui.impl.objects.WebImplDObject;
import tbx.web.ui.login.screen.TBXLoginScreen;
import tbx.web.ui.login.screen.TBXLoginScreen.ITBXLoginScreenActionCallback;


public class LoginWindow extends Window implements ITBXLoginScreenActionCallback
{

	public interface ILoginWindowCallback
	{
		public void logIn( WebImplDObject userDetails );

		public void createNewUser();
	}

	private static final long	serialVersionUID	= 1L;
	TBXLoginScreen				loginScreen;
	ILoginWindowCallback		loginWindowCallback;

	public LoginWindow( ILoginWindowCallback callback,TBXUIFactory tbxuiFactory )
	{
		super( "Jarvis" );
		this.loginWindowCallback = callback;

		loginScreen = tbxuiFactory.createLoginUserScreen( this );

		setClosable( false );
		setModal( true );
		setWidth( "400px" );
		setHeight( "200px" );
		setWindowMode( WindowMode.NORMAL );
		setResizable( false );
		center( );
		setImmediate( true );
		setContent( loginScreen );
	}

	public void loginFailed()
	{
		setContent( loginScreen );

	}

	public void loginFailed( String customMessage )
	{
		loginFailed( );
		Notification.show( customMessage , Type.ERROR_MESSAGE );

	}

	@Override
	public void logIn( WebImplDObject userDetails )
	{
		setContent( new TBXWaitingIndicatorComponent( ) );
		loginWindowCallback.logIn( userDetails );
	}

	@Override
	public void createNewUser()
	{
		// TODO Auto-generated method stub

	}
}
