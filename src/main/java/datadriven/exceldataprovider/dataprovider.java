package datadriven.exceldataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	@Test(dataProvider = "driventest")
	public void testcasedata(String greetings,String communication,String id)
	{
		System.out.println(greetings+communication+id);
	}
	
	@DataProvider(name="driventest")
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		Object [][]data= {{"Hello","Bye","12"},{"Hi","SeeUsoon","14"},{"Namaste","Vandenegalu","16"}};
		return data;

		
		 
		 
	}
	
	

}
