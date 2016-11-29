package com.above.geminisis.rest_api;

import com.jayway.restassured.RestAssured;

public class RestProperties {
	
	private static String basePath;
	private static String baseHost;
	//log.info("Loading automation properties file");
	
	
	public static void intialize() {
		
	 String port = System.getProperty("server.port");
	 
     if (port == null) {
         RestAssured.port = Integer.valueOf(8080);
     }
     else{
         RestAssured.port = Integer.valueOf(port);
     }


     basePath = System.getProperty("server.base");
     if(basePath==null){
         basePath = "/rest-garage-sample/";
     }
     RestAssured.basePath = basePath;

     baseHost = System.getProperty("server.host");
    
     if(baseHost==null){
         baseHost = "http://localhost";
     }
     RestAssured.baseURI = baseHost;

 }
}

