package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By emailAddressLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By submitBtnLocator = By.id("SubmitLogin");

    public LoginPage(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
    }

    public void setEmailAddress(String emailAddress){
        WebElement emailTextBox = browser.findElement(emailAddressLocator);
        emailTextBox.clear();
        emailTextBox.sendKeys(emailAddress);
    }

    public void setPassword(String password){
        WebElement passwordTextBox = browser.findElement(passwordLocator);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickSignInBtn(){
        WebElement signInBtn = browser.findElement(submitBtnLocator);
        signInBtn.click();
    }
}
