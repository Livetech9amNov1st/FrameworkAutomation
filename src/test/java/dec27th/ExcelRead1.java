package dec27th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead1 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("D:\\008 LiveTech\\jars\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		System.out.println("LastRowNum "+ws.getLastRowNum());
		
		System.out.println("PhysicalNumberOfRows  "+ws.getPhysicalNumberOfRows());
		
		XSSFRow row=null;
		XSSFCell  cell=null;
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			row=ws.getRow(i);
			
			//System.out.println("LastCellNum  "+row.getLastCellNum());
			//System.out.println("PhysicalNumberOfCells  "+row.getPhysicalNumberOfCells());
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				cell=row.getCell(j);
				
				if(cell.getCellType()==CellType.STRING)
				{
					System.out.println(cell.getStringCellValue()+" is a String");
				}
				else if(cell.getCellType()==CellType.NUMERIC)
				{
					System.out.println(cell.getNumericCellValue()+" is a Number");
				}
				else if(cell.getCellType()==CellType.BOOLEAN)
				{
					System.out.println(cell.getBooleanCellValue()+" is a Boolean");
				}
			}
			
		}

	}

}
