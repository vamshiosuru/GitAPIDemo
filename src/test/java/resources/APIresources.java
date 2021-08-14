package resources;

public enum APIresources {

	
	Addplace("/maps/api/place/add/json"),
	DeletePlace("/maps/api/place/delete/json"),
	GetPlace("/maps/api/place/get/json"),
	UpdatePlace("/maps/api/place/update/json");
	private String resource;
	
	private APIresources(String resource)
	{
		this.resource=resource;
	}
	public String getResource()
	{
		return resource;
	}
	
	
}
