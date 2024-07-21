package objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Loginpage {
private WebDriver driver;
public Loginpage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name = "email")
private WebElement mail;

@FindBy(name = "password")
private WebElement password;

@FindBy(css = "input[value=\"Login\"]")
private WebElement loginBtn;

public void sendUserEmails(String mail) {
	
	this.mail.sendKeys(mail);
}

public void sendPassword(String password) {
	
	this.password.sendKeys(password); 
}

public void clickLoginBtn() {
	this.loginBtn.click(); 
}


}
