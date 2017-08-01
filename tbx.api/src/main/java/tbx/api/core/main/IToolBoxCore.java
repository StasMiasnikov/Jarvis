package tbx.api.core.main;





import java.util.List;


import tbx.api.core.connectors.IRegistryConnector;
import tbx.api.core.dObject.DObject;


public interface IToolBoxCore
{

	public void start();

	public void stop();

	public boolean addConnector( IRegistryConnector connector );

	public boolean removeConnector( IRegistryConnector connector );

	public List<IRegistryConnector> getAllConnectorsUnmodifiable();

	public boolean canStart();

	public void updateDobject( DObject dObjectTUpdate );


}
