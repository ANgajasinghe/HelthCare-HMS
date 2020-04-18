package utility;



public class GMessage {
	
	public static String Unauthorize = "User Cannot Access the resource"; 
	
	public static String addToken ="You have to have a bearer token to get this services";
	
	public static String nodata="Couldn't find requested data from database  : ";
	
	public static String invalid = "Invalid User Input : ";
	
	public static String logfirt = "Please Login or register first";
	
	public static String wrongPwd = "Incorrect username or password";
	
	public static String path(String path) {
		return "/"+path;
	}
}
