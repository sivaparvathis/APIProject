package com.atlassian.developer.workExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import com.atlassian.developer.utils.ExcelUtils;

public class ExcelMethods {
	

	public void readexcelsheet() throws FileNotFoundException, IOException
	{
		ExcelUtils ex=new ExcelUtils();
		Workbook wbk=ex.createworksheetObj();
				
		Sheet st=wbk.getSheet("Sheet1");
		
		Row rw=st.getRow(0);
		
		System.out.println(rw.getCell(0));
		
		
	}
	

	public void writeexcelsheet() throws FileNotFoundException, IOException
	{
		String[] write = {"Data3","Data4"};
		String filename="C://Users//JO//eclipse-advanceworkspace//Jira-RestApis//src//main//resources//readexcel.xlsx";
				ExcelUtils ex=new ExcelUtils();
		Workbook wbk=ex.createworksheetObj();
		Sheet st=wbk.getSheet("Sheet1");
		Row rw=st.getRow(0);
		int rownum=st.getLastRowNum()-st.getFirstRowNum();
		System.out.println("rownum:"+ rownum);
		
	
    	Row rwn=st.createRow(rownum+1);
    	System.out.println("cell count:"+rw.getLastCellNum());

        for(int j = 0; j < rw.getLastCellNum(); j++)
        {

                Cell cel = rwn.createCell(j);

            cel.setCellValue(write[j]);

		}
		wbk.write(new FileOutputStream(new File(filename)));
				

		wbk.close();
		
		
	}
	
	
	//given start row and column number in the excel
	@Test
	public void writeFromGivenRNC() throws FileNotFoundException, IOException
	{    
		int writeRow=11;
		int writeCell=1;
	
		String[] write = {"Data3","Data4"};
		String filename="C://Users//JO//eclipse-advanceworkspace//Jira-RestApis//src//main//resources//readexcel.xlsx";
		ExcelUtils ex=new ExcelUtils();
		Workbook wbk=ex.createworksheetObj();
		Sheet st=wbk.getSheet("Sheet1");

    	Row rwn=st.createRow(writeRow-1);
    	
        for(int j = writeCell,i=0; j < (writeCell+write.length); j++,i++)
        {
                Cell cel = rwn.createCell(j-1);

            cel.setCellValue(write[i]);


		}
		wbk.write(new FileOutputStream(new File(filename)));
				

		wbk.close();
	}
	
	

}
