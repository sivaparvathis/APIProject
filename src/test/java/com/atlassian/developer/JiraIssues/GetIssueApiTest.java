package com.atlassian.developer.JiraIssues;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

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

public class GetIssueApiTest extends CreateSessionId {
	
		@Test(dataProvider="getIssueResources")
		public void getIssuebyIdorKey(String resource) throws IOException
		{
			RestAssured.baseURI=prop.getProperty("BASEURI");
			RestAssured.basePath=resources.createIssueResources();
			ExtractableResponse<Response> response=given().
				   pathParam("idorkey", resource).
				   cookie(CreateSessionTest.sessionIdName, CreateSessionTest.sessionIdValue).
			       header("Content-Type", "application/json").
			      when().log().all().
		           get("/{idorkey}").
		    then().statusCode(200).log().all().extract();
			String filename="\\get_issueIdorKey_"+JavaUtils.timeStamp();
		FileUtils.writeFile(filename, response);
		
		//JsonPath jpath=new JsonPath(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources"+filename+".json")));
		//sessionIdName= jpath.get("session.name");	
		//sessionIdValue=jpath.get("session.value");
		
		}
		
		@DataProvider(name="getIssueResources")
		public Object[][] getIssueResources()
		{
			return new Object[][] {{IssueApiTest.issueId},{IssueApiTest.issueKey}};
			
		}

}
