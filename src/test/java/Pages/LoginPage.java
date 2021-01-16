package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By emailAddressLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By submitBtnLocator = By.id("SubmitLogin");
    private By errorMsgLocator = By.cssSelector("div[class = 'alert alert-danger'] > ol > li");

    public LoginPage(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        waitForPageTitle("Login - ");
    }

    public UserAccountPage login(String emailAddress, String password) throws Exception {
        setEmailAddress(emailAddress);
        setPassword(password);
        clickSignInBtn();
        return new UserAccountPage(browser);
    }

    private LoginPage setEmailAddress(String emailAddress){
        WebElement emailTextBox = browser.findElement(emailAddressLocator);
        emailTextBox.clear();
        emailTextBox.sendKeys(emailAddress);
        return this;
    }

    private LoginPage setPassword(String password){
        WebElement passwordTextBox = browser.findElement(passwordLocator);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
        return this;
    }

    private UserAccountPage clickSignInBtn() throws Exception {
        WebElement signInBtn = browser.findElement(submitBtnLocator);
        signInBtn.click();
        checkForLoginFailure();
        return new UserAccountPage(browser);
    }

    private void checkForLoginFailure() throws Exception {
        try{
            waitForPageTitle("Login - ");
        }
        catch(TimeoutException ex){
            String errorMsg = browser.findElement(errorMsgLocator).getText();
            throw new Exception("Login failure: " + errorMsg);
        }
    }
}
