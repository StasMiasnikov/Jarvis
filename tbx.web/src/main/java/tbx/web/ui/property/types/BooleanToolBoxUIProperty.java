package tbx.web.ui.property.types;





import tbx.web.ui.property.BaseToolBoxUIProperty;


public class BooleanToolBoxUIProperty extends BaseToolBoxUIProperty<Boolean>
{

	@Override
	protected Object getValueRef()
	{
		return new Boolean( false );
	}

}
