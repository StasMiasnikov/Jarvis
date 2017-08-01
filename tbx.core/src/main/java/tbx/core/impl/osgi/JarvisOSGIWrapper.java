package tbx.core.impl.osgi;





import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;


import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;


public class JarvisOSGIWrapper
{

	public enum WRAPPER_STATUS
	{
		STOPPED , STOPPING , STARTING , STARTED
	}

	private Framework		framework;

	private WRAPPER_STATUS	status;

	public JarvisOSGIWrapper()
	{
		try
		{

			FrameworkFactory frameworkFactory = ServiceLoader.load( FrameworkFactory.class ).iterator( ).next( );

			Map<String,String> config = new HashMap<String,String>( );

			// -Dosgi.configuration.area=@user.home/.eclipse
			// osgi.shell.telnet.port, 6666
			config.put( "osgi.configuration.area" , System.getProperty( "user.home" ) );
			config.put( "osgi.shell.telnet.port" , "6666" );
			framework = frameworkFactory.newFramework( config );
			frameworkFactory = null;
		}
		catch ( Exception ex )
		{
			ex.printStackTrace( );// TODO
		}
	}

	public WRAPPER_STATUS getStatus()
	{
		return status;
	}

	public JarvisOSGIWrapper start()
	{
		status = WRAPPER_STATUS.STARTING;
		try
		{

			framework.init( );
			framework.start( );
		}
		catch ( BundleException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}

		status = WRAPPER_STATUS.STARTED;
		return this;
	}

	public void stop()
	{
		status = WRAPPER_STATUS.STOPPING;
		try
		{
			framework.stop( );
			framework = null;
		}
		catch ( BundleException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}
		status = WRAPPER_STATUS.STOPPED;

	}

}
