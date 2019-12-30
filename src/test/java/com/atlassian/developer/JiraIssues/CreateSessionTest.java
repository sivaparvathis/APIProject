package com.atlassian.developer.JiraIssues;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atlassian.developer.base.CreateSessionId;
import com.atlassian.developer.payLoads.PayLoads;
import com.atlassian.developer.resorces.resources;
import com.atlassian.developer.utils.FileUtils;
import com.atlassian.developer.utils.JavaUtils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class CreateSessionTest extends CreateSessionId {
	
	static String sessionIdName;
	static String sessionIdValue;
		@Test	
		public void returnSessionId() throws IOException
		{
			RestAssured.baseURI=prop.getProperty("BASEURI");
			RestAssured.basePath=resources.createSessionResources();
			ExtractableResponse<Response> response=given().
			       header("Content-Type", "application/json").
			       body(PayLoads.createSessionPayload()).
		    when().log().all().
		           post().
		    then().statusCode(200).log().all().extract();
			String filename="\\create_SessionId_"+JavaUtils.timeStamp();
		FileUtils.writeFile(filename, response);
		
		JsonPath jpath=new JsonPath(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources"+filename+".json")));
		sessionIdName= jpath.get("session.name");	
		sessionIdValue=jpath.get("session.value");
		
		}


}
