package persistence;

public class PersistenceFactory {

	public static PersistenceService getPersistenceService(){
		return new PersistenceServiceFakeImpl();
	}
	
}
