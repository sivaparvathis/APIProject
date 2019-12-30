package com.atlassian.developer.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {
	
	Workbook wb=null;
	
	
	public Workbook createworksheetObj() throws FileNotFoundException, IOException
	
	{
		
		String filepath="C://Users//JO//eclipse-advanceworkspace//Jira-RestApis//src//main//resources//readexcel.xlsx";		
		String fileextn=filepath.split("\\.")[1];
	
		if(fileextn.equalsIgnoreCase("xlsx"))
		{
		   wb=new XSSFWorkbook(new FileInputStream(new File(filepath)));
		   
		}
		else
		{
		   wb=new HSSFWorkbook(new FileInputStream(new File(filepath)));
		   
		}
	
			return wb;
		
	}


	
	

	
	
}
