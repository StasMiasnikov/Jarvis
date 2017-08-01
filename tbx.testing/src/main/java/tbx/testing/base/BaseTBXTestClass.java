package tbx.testing.base;





import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


import tbx.api.core.main.IToolBoxCore;


@FixMethodOrder ( MethodSorters.NAME_ASCENDING )
public abstract class BaseTBXTestClass
{

	protected IToolBoxCore toolBoxCore;

}
