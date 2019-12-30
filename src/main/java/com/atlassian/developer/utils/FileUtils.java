package com.atlassian.developer.utils;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class FileUtils
{

public static void writeFile(String fileName , ExtractableResponse<Response> res) throws IOException 
{
	FileOutputStream fos=new FileOutputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources"+fileName+".json")) ;
	fos.write(res.asByteArray());
	fos.close();

}

}