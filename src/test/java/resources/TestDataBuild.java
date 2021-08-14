package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplacepojo;
import pojo.DeletePlacepojo;
import pojo.Locationpojo;

public class TestDataBuild {

	public  Addplacepojo  addplacepayload(String name,String language,String Address)
	{
		Addplacepojo place=new Addplacepojo();
		Locationpojo l=new Locationpojo();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		place.setLocation(l);
		List<String> a=new ArrayList<String>();
		a.add("shoe park");
		a.add("shop");
		place.setTypes(a);
		place.setLocation(l);
		place.setAccuracy(20);
		place.setAddress(Address);
		place.setName(name);
		place.setLanguage(language);
		place.setPhone_number("\"(+91) 983 893 3937");
		
		return place;
	}
	
	public DeletePlacepojo deleteplacepayload(String placeid)
	{
		DeletePlacepojo d=new DeletePlacepojo();
		d.setPlace_id(placeid);
		return d;
	}
}
