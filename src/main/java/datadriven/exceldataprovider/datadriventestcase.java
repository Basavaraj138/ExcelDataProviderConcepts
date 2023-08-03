package datadriven.exceldataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadriventestcase {
	
	
	
	DataFormatter formatter=new DataFormatter();
	@Test(dataProvider = "driventest")
	
	public void testcasedata(String greetings,String communication,String id)
	{
		
		System.out.println(greetings+communication+id);
	}
	@DataProvider(name="driventest")
	public Object[][] datadriven1() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("\\C:\\Users\\welcome\\Desktop\\testdata1.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		int rowcount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		 short columncount = row.getLastCellNum();
			Object data[][]=new Object[rowcount-1][columncount];
		for(int i=0;i<rowcount-1;i++)
		{
			row = sheet.getRow(i+1);
			for(int j=0;j<columncount;j++)
			{
				XSSFCell cell = row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
				
			}
			
		}
		return data;
	}

}
