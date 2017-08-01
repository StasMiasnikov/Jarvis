package tbx.web.ui.screens.main;





import com.vaadin.ui.GridLayout;


import tbx.web.ui.impl.objects.WebImplDObject;
import tbx.web.ui.screens.base.ITBXBoundedScreen;


public class JarvisMainScreen extends GridLayout implements ITBXBoundedScreen
{

	private static final long	serialVersionUID	= 1L;
	WebImplDObject				userObject;

	// TODO each of screen parts will be bounded screen
	ITBXBoundedScreen			navigationArea;
	ITBXBoundedScreen			menuArea;
	ITBXBoundedScreen			notificationArea;
	ITBXBoundedScreen			contentArea;
	ITBXBoundedScreen			editArea;

	public JarvisMainScreen()
	{
		super( 3 , 3 );
		setSizeFull( );

	}

	public void buildME()
	{
		addComponent( navigationArea , 0 , 0 , 0 , 2 );
		// TODO add rest of elements
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
		return userObject;
	}

	@Override
	public void setBoundedObject( WebImplDObject dobjectToSet )
	{
		this.userObject = dobjectToSet;

	}

	public WebImplDObject getUserObject()
	{
		return userObject;
	}

	public void setUserObject( WebImplDObject userObject )
	{
		this.userObject = userObject;
	}

	public ITBXBoundedScreen getNavigationArea()
	{
		return navigationArea;
	}

	public void setNavigationArea( ITBXBoundedScreen navigationArea )
	{
		this.navigationArea = navigationArea;
	}

	public ITBXBoundedScreen getMenuArea()
	{
		return menuArea;
	}

	public void setMenuArea( ITBXBoundedScreen menuArea )
	{
		this.menuArea = menuArea;
	}

	public ITBXBoundedScreen getNotificationArea()
	{
		return notificationArea;
	}

	public void setNotificationArea( ITBXBoundedScreen notificationArea )
	{
		this.notificationArea = notificationArea;
	}

	public ITBXBoundedScreen getContentArea()
	{
		return contentArea;
	}

	public void setContentArea( ITBXBoundedScreen contentArea )
	{
		this.contentArea = contentArea;
	}

	public ITBXBoundedScreen getEditArea()
	{
		return editArea;
	}

	public void setEditArea( ITBXBoundedScreen editArea )
	{
		this.editArea = editArea;
	}

}
