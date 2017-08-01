package tbx.connectors.persistance.jdbc;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;


import com.fasterxml.jackson.databind.ObjectMapper;


import tbx.api.core.connectors.IRegistryBackendConnector;
import tbx.api.core.connectors.ICoreBackendConnectorCallback;
import tbx.api.core.dObject.DObject;
import tbx.api.core.dObject.property.JarvisDObjectProperty;


//TODO for now the connection will be managed in the connector , later will be moved to core
//TODO get path for files from outside
//TODO option for in-memory DB
public class HsqlConnector implements IRegistryBackendConnector
{
	ICoreBackendConnectorCallback	backendConnectorCallback;
	Connection						connection	= null;
	ResultSet						resultSet	= null;
	Statement						statement	= null;

	public HsqlConnector()
	{

		try
		{
			connect( );

			checkForSchema( );

		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}

	}

	private void checkForSchema()
	{
		/*
		 * 
		 * 
		 * CREATE TABLE Persons ( PersonID int, LastName varchar(255), FirstName varchar(255), Address varchar(255), City varchar(255) );
		 * 
		 * 
		 */
		try
		{
			Statement statemnt = connection.createStatement( );
			ResultSet res = statemnt.executeQuery( "SELECT * FROM DOBJECT WHERE OBJECT_ID=-123" );

		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
			String createTableQuery = "CREATE TABLE DOBJECT (OBJECT_ID varchar(255),OBJ varchar(255) ) ";
			Statement statement = null;
			try
			{
				statement = connection.createStatement( );
			}
			catch ( SQLException e2 )
			{
				// TODO Auto-generated catch block
				e2.printStackTrace( );
			}
			try
			{
				statement.executeQuery( createTableQuery );
			}
			catch ( SQLException e1 )
			{
				// TODO Auto-generated catch block
				e1.printStackTrace( );
			}
		}

	}

	@Override
	public String getName()
	{

		return "HSQL CONNECTOR";
	}

	private void connect() throws Exception
	{
		if ( connection == null || connection.isClosed( ) )
		{
			Class.forName( "org.hsqldb.jdbcDriver" );
			connection = DriverManager.getConnection( "jdbc:hsqldb:file:testfiles" , "SA" , "" );
		}
	}

	@Override
	public void executeQuery( DObject dObjectQuery )
	{
		// TODO continue
		try
		{
			connect( );
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}
		DObject dObject = new DObject( );
		dObject.addOrChangeProperty( new JarvisDObjectProperty( "UserName" , "Stanislav" ) );
		dObject.addOrChangeProperty( new JarvisDObjectProperty( "Password" , "you" ) );
		this.backendConnectorCallback.queryReturned( dObject );

	}

	@Override
	public void addQueryReturnCallback( ICoreBackendConnectorCallback callback )
	{
		this.backendConnectorCallback = callback;
	}

	@Override
	public void loadDobject( DObject dObject )
	{
		try
		{
			connect( );
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}

		DObject returnResult = null;

		try
		{

			PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM DOBJECT WHERE OBJECT_ID=?" );
			preparedStatement.setString( 1 , String.valueOf( dObject.getId( ) ) );
			ResultSet resultSet = preparedStatement.executeQuery( );
			if ( resultSet.getFetchSize( ) != 0 )
			{
				resultSet.next( );
				// String objectId = resultSet.getString( "id" );
				String rawObjectDesc = resultSet.getString( "obj" );
				ObjectMapper objectMapper = new ObjectMapper( );
				returnResult = objectMapper.readValue( rawObjectDesc , DObject.class );
			}

		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}

		backendConnectorCallback.queryReturned( returnResult );

	}

	@Override
	public void saveDobject( DObject dObject )
	{
		try
		{
			connect( );
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}

		try
		{

			PreparedStatement preparedStatement = connection.prepareStatement( "UPDATE DOBJECT SET OBJ=? where OBJECT_ID=?" );
			preparedStatement.setString( 2 , String.valueOf( dObject.getId( ) ) );
			ObjectMapper objectMapper = new ObjectMapper( );
			String jsonObejctString = objectMapper.writeValueAsString( dObject );
			preparedStatement.setString( 1 , jsonObejctString );

			Logger.getAnonymousLogger( ).info( "Updated : " + preparedStatement.executeUpdate( ) + "Objects" );
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}

	}

	@Override
	public void checkAndInitSchema( DObject schemaObject )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewObject( DObject dObject )
	{
		try
		{
			connect( );
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}

		try
		{

			String insertTableSQL = "INSERT INTO DOBJECT" + "(OBJECT_ID, OBJ) VALUES" + "(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement( insertTableSQL );

			preparedStatement.setString( 1 , String.valueOf( dObject.getId( ) ) );
			preparedStatement.setString( 2 , new ObjectMapper( ).writeValueAsString( dObject ) );

			preparedStatement.executeUpdate( );
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}

	}

}
