package tbx.web.ui.login.screen;





import com.vaadin.data.validator.NullValidator;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;


import tbx.api.core.dObject.property.JarvisDObjectProperty;
import tbx.web.ui.component.wrappers.TBXButton;
import tbx.web.ui.impl.objects.WebImplDObject;
import tbx.web.ui.screens.base.ITBXBoundedScreen;


public class TBXLoginScreen extends FormLayout implements ITBXBoundedScreen
{

	private static final long		serialVersionUID	= 1L;

	TextField						txtUserName			= new TextField( "Username" );
	PasswordField					txtPass				= new PasswordField( "Password" );

	TBXButton						btnLogin			= new TBXButton( " Login " );
	ITBXLoginScreenActionCallback	loginCallback		= null;

	private WebImplDObject			userDetailsObject;

	public TBXLoginScreen()
	{
		init( );
		clear( );
		setMargin( true );

	}

	public TBXLoginScreen( String title , ITBXLoginScreenActionCallback callback )
	{
		this( );
		this.loginCallback = callback;
	}

	public void setLoginCallback( ITBXLoginScreenActionCallback loginCallback )
	{
		this.loginCallback = loginCallback;
	}

	private void init()
	{
		// init username box
		txtUserName.setNullRepresentation( "enter username here" );
		txtUserName.setRequired( true );
		txtUserName.addValidator( new NullValidator( "Cannot be null" , false ) );// TODO check why it is not being applied
		// init userpass box
		txtPass.setNullRepresentation( "enter password here" );
		txtPass.setRequired( true );
		txtPass.addValidator( new NullValidator( "Cannot be null" , false ) );

		// init login button
		btnLogin.addClickListener( new ClickListener( )
		{

			private static final long serialVersionUID = 1L;

			public void buttonClick( ClickEvent event )
			{

				if ( isValid( ) )
				{
					userDetailsObject.addOrChangeProperty( new JarvisDObjectProperty( "UserName" , txtUserName.getValue( ) ) , new JarvisDObjectProperty( "Password" , txtPass.getValue( ) ) );
				}
				else
				{
					Notification.show( "Invalid input" , Type.ERROR_MESSAGE );
				}
			}
		} );

		addComponent( txtUserName );
		addComponent( txtPass );
		addComponent( btnLogin );

	}

	public final void clear()
	{
		txtUserName.clear( );
		txtPass.clear( );

		btnLogin.setVisible( true );
	}

	protected boolean isValid()
	{
		return txtUserName.getValue( ).length( ) != 0 && txtPass.getValue( ).length( ) != 0;// TODO
	}

	public interface ITBXLoginScreenActionCallback
	{
		public void logIn( WebImplDObject userDetails );

		public void createNewUser();

	}

	@Override
	public WebImplDObject getBoundedObject()
	{
		return userDetailsObject;
	}

	@Override
	public void setBoundedObject( WebImplDObject dobjectToSet )
	{
		this.userDetailsObject = dobjectToSet;

	}

	@Override
	public void webUIdObjectChanged( WebImplDObject implDObject )
	{
		txtUserName.setValue( userDetailsObject.getPropertyByName( "UserName" ).getValue( ).toString( ) );

	}
}
