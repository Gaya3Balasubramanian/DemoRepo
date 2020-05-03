package utilclass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

public class TestUtil extends TestBase {

	/*
	 * Remember we need to mention as public , else we will not be able to use this
	 * variable anywhere. If we mention it as public in that case it is considered
	 * as global variable
	 * 
	 */

	public static long Page_Load_Time = 20;
	public static long Implicit_wait = 10;
	public static String TEST_DATA_PATH = "C:\\Users\\kaarthic\\eclipse-workspace\\LetsKodeit\\src\\main\\java\\testdata\\LetsKodeitTestData.xlsx";
	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String SheetName) {
		FileInputStream file = null;

		try {
			file = new FileInputStream(TEST_DATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IllegalFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet(SheetName);
       Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    		 
    		   for(int i=0;i<sheet.getLastRowNum();i++) {
    			   for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
    				   data[i][j]=sheet.getRow(i+1).getCell(j).toString();
    			   }
    		   }
       
       return data;
	}
	
	
	
	
	public static void takeScreenshotAtendoftest() throws IOException {
		File srcfile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentdir=prop.getProperty("ScreenShot");
		FileUtils.copyFile(srcfile, new File(currentdir+System.currentTimeMillis()+".png"));
		
		
		
		
	}
}
