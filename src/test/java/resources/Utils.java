package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	public RequestSpecification  requestSpecification () throws IOException
	{
		
		
		//req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").
		if(req==null)
		{
			PrintStream log= new PrintStream (new FileOutputStream("logging.txt"));
				req= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123").
				addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType("application/json").build();
				return req;
		}
		return req;
	}
	
	public static String getGlobalValue(String property) throws IOException
	{
		Properties prop=new Properties();
		
		FileInputStream fs=new  FileInputStream("E:\\workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fs);
		return prop.getProperty(property);
		
	}
	public static String getResponseelement(Response response,String element)
	{
		String resp=response.asString();
		JsonPath js=new JsonPath(resp);
		return js.getString(element);
		
	}
}
