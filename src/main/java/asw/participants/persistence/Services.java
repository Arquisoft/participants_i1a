package asw.participants.persistence;

public class Services {

	public static UserService getUserService(){
		return new UserServiceFakeImpl();
	}
	
}
