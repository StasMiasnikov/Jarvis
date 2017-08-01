package tbx.web.context;





import java.util.ServiceLoader;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


import tbx.api.core.main.IToolBoxCore;


@WebListener
public class ContextListener implements ServletContextListener
{
	public static IToolBoxCore core;

	@Override
	public void contextDestroyed( ServletContextEvent sce )
	{
		try
		{

			core.stop( );
			core = null;

		}

		catch ( Exception ex )
		{
			ex.printStackTrace( );// TODO
		}
	}

	@Override
	public void contextInitialized( ServletContextEvent sce )
	{

		try
		{

			// TODO more than one core in class path , alert on this!
			core = ServiceLoader.load( IToolBoxCore.class ).iterator( ).next( );

			core.start( );

		}

		catch ( Exception ex )
		{
			ex.printStackTrace( );// TODO
		}
	}

}
