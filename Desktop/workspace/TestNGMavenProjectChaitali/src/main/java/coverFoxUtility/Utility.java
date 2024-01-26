package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		Reporter.log("Reading data from excelSheet",true);
		FileInputStream myfile=new FileInputStream("C:\\Users\\DELL\\Desktop\\ChaitaliTestingNotes\\coverFoxExcell.xlsx");
		Sheet mySheet=WorkbookFactory.create(myfile).getSheet("Sheet1");
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	public static void takeScreenShot(WebDriver driver,String name) throws IOException
	{
		Reporter.log("Take screenshot",true);
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\DELL\\Desktop\\ChaitaliTestingNotes\\ScreenShotPractice"+name+"_"+timeStamp+".png");
		Reporter.log("Saved screenshot at"+dest,true);
		FileHandler.copy(src, dest);
	}
	public static String readDataFromProperty(String key) throws IOException
	{
		//Create object of properties
		Properties prop=new Properties();
		
		//Create Object of FileInputStream
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\testData.properties");
		prop.load(myFile);
		String values = prop.getProperty(key);
		return values;
	}
}

















