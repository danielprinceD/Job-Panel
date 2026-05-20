package coupling.loosely.Provider;

public class UserDataBaseProviderImpl implements DataBaseProvider
{
	@Override public String getUserDetails()
	{
		return "User details from database";
	}
}
