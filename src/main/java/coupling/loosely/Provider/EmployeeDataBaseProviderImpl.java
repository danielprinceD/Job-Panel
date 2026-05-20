package coupling.loosely.Provider;

public class EmployeeDataBaseProviderImpl implements DataBaseProvider
{
	@Override public String getUserDetails()
	{
		return "Employee details from database";
	}
}
