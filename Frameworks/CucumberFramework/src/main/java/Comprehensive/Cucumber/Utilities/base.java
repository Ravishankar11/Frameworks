package Comprehensive.Cucumber.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base
{
	public static Properties prop;
	public static WebDriver driver;
	
	public WebDriver initiateDriver() throws IOException
	{
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("F:\\eclipse java\\ComprehensiveAssessment\\HybridFramework\\src\\main\\java\\Comprehensive\\Hybrid\\Resources\\data.properties");
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", "F:\\eclipse java\\ComprehensiveAssessment\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		//driver=fromListeners();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("F:\\eclipse java\\ComprehensiveAssessment\\HybridFramework\\Screenshots\\"+result+"screenshot.png"));
		
	}
}