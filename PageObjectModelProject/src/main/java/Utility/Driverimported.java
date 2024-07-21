package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverimported {
private static WebDriver driver; 
	
	public static WebDriver getDriver(String drivers){

		if(drivers.equals(Drivers.CHROME)){
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
			
		}else if(drivers.equals(Drivers.FIREFOX)){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(drivers.equals(Drivers.Edge)){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
