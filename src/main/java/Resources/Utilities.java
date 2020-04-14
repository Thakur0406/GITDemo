package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utilities {
	
	public WebDriver driver = null;
	public Properties properties;
	
		public WebDriver InitialiseDriver() throws IOException{
		
		properties = new Properties();
		FileInputStream Filename = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalVariable.properties");
		
		properties.load(Filename);
		String BrowserName = properties.getProperty("Browser");
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();			
		}else if (BrowserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else if (BrowserName.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
		}
}
