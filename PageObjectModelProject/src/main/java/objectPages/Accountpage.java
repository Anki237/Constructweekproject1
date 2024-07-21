package objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Accountpage {
	private WebDriver driver;

    @FindBy(linkText = "Password")
    WebElement changePasswordLink;

    @FindBy(id = "input-password")
    WebElement newPassword;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(css = "[class=\"alert alert-success alert-dismissible\"]")
    WebElement successMessage;

    @FindBy(linkText = "Logout")
    WebElement logoutLink;
    @FindBy(linkText = "Login")
    WebElement loginlink;

    public Accountpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToChangePassword() {
        changePasswordLink.click();
    }

    public void changePassword(String newPass, String confirmPass) {
        newPassword.sendKeys(newPass);
        confirmPassword.sendKeys(confirmPass);
        continueButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void logout() {
        logoutLink.click();
    }
    public void login() {
    	loginlink.click();
    }
    public void assertPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
		  SoftAssert sa= new SoftAssert();
		  sa.assertEquals(actualTitle, expectedTitle);
		  sa.assertAll();
	}
        
}
