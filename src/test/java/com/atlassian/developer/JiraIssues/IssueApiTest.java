package com.atlassian.developer.JiraIssues;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;
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

public class IssueApiTest extends CreateSessionId {
	static protected String issueId;
	static protected String issueKey;
	
	@Test
	public void createissue() throws IOException
	{
		RestAssured.baseURI=prop.getProperty("BASEURI");
		RestAssured.basePath=resources.createIssueResources();
		ExtractableResponse<Response> response=given().
				cookie(CreateSessionTest.sessionIdName, CreateSessionTest.sessionIdValue).			   
		       header("Content-Type", "application/json").
		       body(PayLoads.createIssuePayload()).
	    when().log().all().
	           post().
	    then().statusCode(201).log().all().extract();
		String filename="\\create_Issue_"+JavaUtils.timeStamp();
	FileUtils.writeFile(filename, response);
	JsonPath jpath=new JsonPath(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources"+filename+".json")));
	issueId= jpath.get("id");	
	issueKey=jpath.get("key");
	
		
	}
	
	
	
	

}
