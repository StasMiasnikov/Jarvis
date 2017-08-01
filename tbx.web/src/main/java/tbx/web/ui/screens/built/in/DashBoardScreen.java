package tbx.web.ui.screens.built.in;





import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;


import tbx.web.ui.impl.objects.WebImplDObject;


public class DashBoardScreen extends VerticalLayout implements IJarvisBuiltInScreen
{
	WebImplDObject				dashBoardItemsLIst;
	private static final long	serialVersionUID	= 1L;

	public DashBoardScreen()
	{
		addComponent( new Button( "DashBoard" , FontAwesome.AMAZON ) );
		setSizeFull( );
	}

	@Override
	public String getTitle()
	{
		// TODO Auto-generated method stub
		return "DashBoard";
	}

	@Override
	public void webUIdObjectChanged( WebImplDObject ref )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public WebImplDObject getBoundedObject()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBoundedObject( WebImplDObject dobjectToSet )
	{
		// TODO Auto-generated method stub

	}

}
