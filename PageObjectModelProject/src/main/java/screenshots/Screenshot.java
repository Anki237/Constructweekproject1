package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	private WebDriver driver;

    
    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenShot(String fileName) throws IOException {
    	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	        try {
    	            FileUtils.copyFile(scrFile, new File("C:/Users/LENOVO/Downloads/" + fileName));
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    	    
    }





}
