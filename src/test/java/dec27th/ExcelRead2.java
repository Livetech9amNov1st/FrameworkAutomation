package dec27th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("D:\\008 LiveTech\\jars\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		String status=ws.getRow(2).getCell(0).getStringCellValue();
		System.out.println(status);

	}

}
