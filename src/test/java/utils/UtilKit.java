package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	
	public static FileInputStream fis1;
	
	public static XSSFWorkbook wb;
	
	public static XSSFSheet ws;
	
	public static HashMap<String,String> getTestData(String testCaseName) throws IOException
	{
		
		HashMap<String, String> testDatMap=new HashMap<String, String>();
		
		fis1=new FileInputStream("src\\test\\resources\\testdata\\excels\\Adactin Master Test Data.xlsx");
		
		wb=new XSSFWorkbook(fis1);
		
		ws=wb.getSheet("testdata");
		
		
		ArrayList<Row> testCaseRows=getTestCaseRows(ws,testCaseName);
		
		System.out.println("testCaseRows.size(): "+testCaseRows.size());
			//int noOfCells=testCaseRows.get(0).getLastCellNum();
			
			//System.out.println("testCaseRows.get(0).getLastCellNum()"+testCaseRows.get(0).getLastCellNum());
			
			for(int i=0;i<testCaseRows.size();i++)
			{
				System.out.println("testCaseRows.get(0).getLastCellNum()"+testCaseRows.get(0).getLastCellNum());
			for(int j=1;j<testCaseRows.get(0).getLastCellNum();j++)
			{
			testDatMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(1).getCell(j).getStringCellValue());
			}
			
			}
		
		return testDatMap;
		
		
	}

	static ArrayList<Row> getTestCaseRows(XSSFSheet ws,String testCaseName) {
		
		System.out.println("testCaseName"+testCaseName);
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(ws.getRow(i)!=null)
			{
				allRows.add(ws.getRow(i));
			}
		}
		
		System.out.println("allRows.size()"+allRows.size());
		
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		for(int i=0;i<allRows.size();i++)
		{
			if(allRows.get(i).getCell(0) != null)
			{
				System.out.println(allRows.get(i).getCell(0).getStringCellValue()+"---"+testCaseName);
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName))
			{
				testCaseRows.add(allRows.get(i));
			}
			}
		}
		
		return testCaseRows;
		
	}

}
