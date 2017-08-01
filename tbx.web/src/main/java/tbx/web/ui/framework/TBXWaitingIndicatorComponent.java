package tbx.web.ui.framework;





import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ProgressBar;


public class TBXWaitingIndicatorComponent extends HorizontalLayout
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private ProgressBar			progressBar;

	public TBXWaitingIndicatorComponent()
	{
		this.progressBar = new ProgressBar( );
		progressBar.setIndeterminate( true );
		addComponent( progressBar );
		setSizeFull( );
		setMargin( true );
		setSpacing( true );
		
	}

}
