package com.above.geminisis.rest_api;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.get;

public class RestTest {

	//First, I declared Response and JsonPath objects.
    private Response res = null; //Response object
    private JsonPath jp = null; //JsonPath object
 
    /*
    Second, we should do setup operations, get JSON response from the API and put it into JsonPath object
    Then we will do query and manipulations with JsonPath class’s methods.
    We can do all of the preparation operations after @Before Junit annotation.
    */
    @BeforeTest
    public void setup (){
        //Test Setup
        RestUtil.setBaseURI("http://fitdistrict.above-inc.net/"); //Setup Base URI
        RestUtil.setBasePath("api"); //Setup Base Path
        RestUtil.setContentType(ContentType.JSON); //Setup Content Type
        RestUtil.createQueryPath("product/findProductAdmin"); //Construct the path
        res = RestUtil.getResponse(); //Get response
        jp = RestUtil.getJsonPath(res); //Get JsonPath
    }
 
    @Test
    public void StatusCodeTest() {
        //Verify the http response status returned. Check Status Code is 200?
    	Assert.assertEquals(600, res.getStatusCode());
    }
	
}