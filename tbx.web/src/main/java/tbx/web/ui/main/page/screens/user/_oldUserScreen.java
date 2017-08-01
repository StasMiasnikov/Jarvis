package tbx.web.ui.main.page.screens.user;





import com.vaadin.data.validator.NullValidator;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;


import tbx.web.ui.property.BaseToolBoxUIProperty;
import tbx.web.ui.property.listeners.IToolBoxUIPropertyChangedListener;
import tbx.web.ui.property.types.BooleanToolBoxUIProperty;
import tbx.web.ui.property.types.StringToolBoxUIProperty;


public class _oldUserScreen extends GridLayout
{

	private static final long				serialVersionUID	= 1L;

	public BaseToolBoxUIProperty<String>	userName			= new StringToolBoxUIProperty( );
	public BaseToolBoxUIProperty<String>	userPassword		= new StringToolBoxUIProperty( );
	public BaseToolBoxUIProperty<String>	userFullName		= new StringToolBoxUIProperty( );
	public BaseToolBoxUIProperty<Boolean>	isLoggedIN			= new BooleanToolBoxUIProperty( );

	Button									btnLoginLogout		= new Button( "Login" );
	Label									lblUserName			= new Label( "Anonymous" );
	Window									windowCredentials	= new Window( "Credentials" );

	public _oldUserScreen()
	{

		super( );

		setRows( 3 );
		setColumns( 3 );
		addComponent( lblUserName , 0 , 1 );
		addComponent( btnLoginLogout , 2 , 1 );

		userFullName.bind( new IToolBoxUIPropertyChangedListener<String>( )
		{

			@Override
			public void notifyPropertyChanged( String newProperty )
			{
				lblUserName.setValue( "Wellcome " + newProperty );

			}
		} );

		isLoggedIN.bind( new IToolBoxUIPropertyChangedListener<Boolean>( )
		{

			@Override
			public void notifyPropertyChanged( Boolean newProperty )
			{
				if ( newProperty )
				{
					handleUserLogin( );
				}
				else
				{
					handleUSerLogout( );
				}

			}

		} );

		setupCredentialsWindow( );

		btnLoginLogout.addClickListener( new ClickListener( )
		{

			@Override
			public void buttonClick( ClickEvent event )
			{
				windowShow( );

			}
		} );
	}

	private void setupCredentialsWindow()
	{
		windowCredentials.setContent( createWIndowContent( ) );
		windowCredentials.setSizeUndefined( );
		windowCredentials.setHeight( "200px" );
		windowCredentials.setWidth( "400px" );

		// Set window position.
		windowCredentials.setPositionX( 200 );
		windowCredentials.setPositionY( 50 );
		windowCredentials.setResizable( false );
		windowCredentials.setClosable( false );
		windowCredentials.setModal( true );
	}

	private Component createWIndowContent()
	{
		FormLayout formLayout = new FormLayout( );
		formLayout.setSpacing( true );
		formLayout.setMargin( true );

		TextField userNameTF = new TextField( "UserName" );
		userNameTF.setIcon( FontAwesome.USER );
		userNameTF.addValidator( new NullValidator( "Must be given" , false ) );
		// userName.bind( userNameTF.getPropertyDataSource( ) );
		formLayout.addComponent( userNameTF );

		TextField password = new TextField( "Password" );
		password.setIcon( FontAwesome.BARCODE );
		password.addValidator( new NullValidator( "Must be given" , false ) );
		formLayout.addComponent( password );

		Button loginButton = new Button( "Login" );
		loginButton.addClickListener( new ClickListener( )
		{

			@Override
			public void buttonClick( ClickEvent event )
			{
				handleUserLogin( );
				userName.setValue( userNameTF.getValue( ) );
				userPassword.setValue( password.getValue( ) );
				userNameTF.setValue( "" );
				password.setValue( "" );
			}
		} );

		Button btnBack = new Button( "Back" );
		btnBack.addClickListener( new ClickListener( )
		{

			@Override
			public void buttonClick( ClickEvent event )
			{
				userNameTF.setValue( "" );
				password.setValue( "" );
				windowHide( );

			}
		} );
		HorizontalLayout layButtonsLayout = new HorizontalLayout( loginButton , btnBack );
		layButtonsLayout.setSpacing( true );
		formLayout.addComponent( layButtonsLayout );

		return formLayout;
	}

	private void windowShow()
	{
		btnLoginLogout.setEnabled( false );
		UI.getCurrent( ).addWindow( windowCredentials );
	}

	private void windowHide()
	{
		btnLoginLogout.setEnabled( true );
		UI.getCurrent( ).removeWindow( windowCredentials );
	}

	private void handleUSerLogout()
	{
		// TODO Auto-generated method stub

	}

	private void handleUserLogin()
	{
		windowHide( );

	}
}
