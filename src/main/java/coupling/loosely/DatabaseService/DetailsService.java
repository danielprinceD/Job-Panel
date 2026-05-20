package coupling.loosely.DatabaseService;

import coupling.loosely.Provider.DataBaseProvider;

import com.annotation.Injector;

public class DetailsService
{
	private final DataBaseProvider dataBaseProvider;

	public DetailsService(DataBaseProvider dataBaseProvider)
	{
		this.dataBaseProvider = dataBaseProvider;
	}
	@Injector
	public String fetchDetails()
	{
		return dataBaseProvider.getUserDetails();
	}
}
