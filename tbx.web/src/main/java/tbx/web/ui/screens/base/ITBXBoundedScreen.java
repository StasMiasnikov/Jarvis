package tbx.web.ui.screens.base;





import com.vaadin.ui.ComponentContainer;


import tbx.web.ui.impl.objects.IUIDobjectChangeListener;
import tbx.web.ui.impl.objects.WebImplDObject;


public interface ITBXBoundedScreen extends ComponentContainer,IUIDobjectChangeListener
{

	public WebImplDObject getBoundedObject();

	public void setBoundedObject( WebImplDObject dobjectToSet );

}
