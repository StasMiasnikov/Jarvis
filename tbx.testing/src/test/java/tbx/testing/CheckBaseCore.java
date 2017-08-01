package tbx.testing;





import org.junit.Assert;
import org.junit.Test;


import tbx.testing.base.BaseTBXTestClass;


public class CheckBaseCore extends BaseTBXTestClass
{

	@Test
	public void checkCOreIsNull()
	{
		Assert.assertNull( "Core found to be null  at BaseTBXTestClass, as expected" , toolBoxCore );
	}
}
