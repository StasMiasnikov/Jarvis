package tbx.api.core.connectors;





import tbx.api.core.dObject.DObject;


public interface IRegistryBackendConnector extends IRegistryConnector
{
	public void loadDobject( DObject dObject );

	public void saveDobject( DObject dObject );

	public void addNewObject( DObject dObject );

	public void executeQuery( DObject dObjectQuery );

	public void addQueryReturnCallback( ICoreBackendConnectorCallback callback );

	public void checkAndInitSchema( DObject schemaObject );
}
