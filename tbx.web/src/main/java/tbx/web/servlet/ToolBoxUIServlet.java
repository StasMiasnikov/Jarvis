package tbx.web.servlet;





import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;


import tbx.web.ui.main.page.ui.MainPageUI;


@WebServlet ( urlPatterns = "/*" , asyncSupported = true )
@VaadinServletConfiguration ( ui = MainPageUI.class , productionMode = false )
@WebListener
public class ToolBoxUIServlet extends VaadinServlet implements SessionInitListener,SessionDestroyListener,ServletContextListener
{

	// TODO move here all init logic from @tb.web.ContextListener
	private static final long serialVersionUID = 1L;

	@Override
	public void sessionDestroy( SessionDestroyEvent event )
	{

	}

	@Override
	public void sessionInit( SessionInitEvent event ) throws ServiceException
	{

	}

	@Override
	public void contextInitialized( ServletContextEvent sce )
	{

	}

	@Override
	public void contextDestroyed( ServletContextEvent sce )
	{

	}
}