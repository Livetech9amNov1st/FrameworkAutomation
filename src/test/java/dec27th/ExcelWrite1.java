package dec27th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite1 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("D:\\008 LiveTech\\jars\\xyz\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet3");
		
		//case 1 : modifying an existing cell
		
		//ws.getRow(1).getCell(1).setCellValue("New LiveTech");
		
		//case 2: creating a cell in existing Row
		
		//ws.getRow(3).createCell(1).setCellValue("Fail");
		
		//case 3: creating a row and cell in it
		
		ws.createRow(5).createCell(0).setCellValue("some value");
		
		FileOutputStream fos=new FileOutputStream("D:\\008 LiveTech\\jars\\xyz\\Book1.xlsx");
		
		wb.write(fos);
		
		wb.close();
		
		System.out.println("End of Program..");

	}

}
