package tbx.web.ui.property.types;





import tbx.web.ui.property.BaseToolBoxUIProperty;


public class FloatToolBoxUIProperty extends BaseToolBoxUIProperty<Float>
{
	Float floatNumber = 0f;

	@Override
	protected Object getValueRef()
	{
		return floatNumber;
	}

}
