package tbx.command.line;





import java.io.IOException;
import java.util.ServiceLoader;
import java.util.logging.Logger;


import tbx.api.core.main.IToolBoxCore;


public class ToolBoxCommandLineRunner
{
	public static void main( String[] args )
	{

		try
		{

			IToolBoxCore iToolBoxCore = ServiceLoader.load( IToolBoxCore.class ).iterator( ).next( );

			Logger.getAnonymousLogger( ).info( "CORE FOUND" );

			iToolBoxCore.start( );
			Logger.getAnonymousLogger( ).info( "CORE STARTED" );

			try
			{
				System.in.read( );
			}
			catch ( IOException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace( );
			}
		}
		catch ( Exception ex )
		{
			ex.printStackTrace( );
		}
	}
}
