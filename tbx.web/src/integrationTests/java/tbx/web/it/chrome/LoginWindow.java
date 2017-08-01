package tbx.web.it.chrome;





import java.util.NoSuchElementException;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.testbench.elements.WindowElement;


public class LoginWindow extends TestBenchTestCase
{
	@Before
	public void setUp() throws Exception
	{
		System.setProperty( "webdriver.chrome.driver" , "C:\\Selenium\\Drivers\\Chrome\\chromedriver.exe" );
		setDriver( new ChromeDriver( ) );
		getDriver( ).get( "http://localhost:8081/tbx.web" );// TODO command line property
	}

	@Test
	public void checkLoginWindowIsClosingAfterClickingLOGIN()
	{

		ButtonElement loginButton = $( ButtonElement.class ).caption( "Login" ).first( );
		loginButton.click( );
		WindowElement credentialsWindow = $$( WindowElement.class ).caption( "Credentials" ).first( );
		TextFieldElement userNameTextField = $( TextFieldElement.class ).caption( "UserName" ).first( );
		userNameTextField.setValue( "Stas" );
		TextFieldElement passwordTextField = $( TextFieldElement.class ).caption( "Password" ).first( );
		ButtonElement subWindowLoginButton = $$( WindowElement.class ).caption( "Credentials" ).$( ButtonElement.class ).caption( "Login" ).first( );
		passwordTextField.setValue( "Stas" );
		subWindowLoginButton.click( );
		try
		{
			$$( WindowElement.class ).caption( "Credentials" );
		}
		catch ( NoSuchElementException noSuchElementException )
		{
			Assert.assertTrue( "Credentials window should be closed" , noSuchElementException.getMessage( ).contains( "com.vaadin.ui.Window[caption=\"Credentials" ) );
		}
	}

	@Test
	public void checkLoginWindowIsClosingAfterClickingBack()
	{

		ButtonElement loginButton = $( ButtonElement.class ).caption( "Login" ).first( );
		loginButton.click( );
		WindowElement credentialsWindow = $$( WindowElement.class ).caption( "Credentials" ).first( );
		TextFieldElement userNameTextField = $( TextFieldElement.class ).caption( "UserName" ).first( );
		userNameTextField.setValue( "Stas" );
		TextFieldElement passwordTextField = $( TextFieldElement.class ).caption( "Password" ).first( );
		passwordTextField.setValue( "Stas" );
		ButtonElement subWindowBackButton = $$( WindowElement.class ).caption( "Credentials" ).$( ButtonElement.class ).caption( "Back" ).first( );

		subWindowBackButton.click( );
		try
		{
			$$( WindowElement.class ).caption( "Credentials" );
		}
		catch ( NoSuchElementException noSuchElementException )
		{
			Assert.assertTrue( "Credentials window should be closed" , noSuchElementException.getMessage( ).contains( "com.vaadin.ui.Window[caption=\"Credentials" ) );
		}
	}

	@After
	public void tearDown() throws Exception
	{
		getDriver( ).quit( );
	}
}
