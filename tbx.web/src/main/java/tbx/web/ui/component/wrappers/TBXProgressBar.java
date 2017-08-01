package tbx.web.ui.component.wrappers;





import tbx.web.ui.property.BaseToolBoxUIProperty;
import tbx.web.ui.property.types.FloatToolBoxUIProperty;


import com.vaadin.ui.ProgressBar;


@SuppressWarnings ( "rawtypes" )
public class TBXProgressBar extends ProgressBar
{

	private static final long	serialVersionUID	= 1L;
	BaseToolBoxUIProperty		valueProperty		= new FloatToolBoxUIProperty( );

	
}
