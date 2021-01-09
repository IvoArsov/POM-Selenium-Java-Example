package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver browserDriver){
        super(browserDriver);
        // Wait for page load
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    public void setEmailAddress(String emailAddress){
        WebElement emailTextBox = browser.findElement(By.id("email"));
        emailTextBox.clear();
        emailTextBox.sendKeys(emailAddress);
    }

    public void setPassword(String password){
        WebElement passwordTextBox = browser.findElement(By.id("passwd"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickSignInBtn(){
        WebElement signInBtn = browser.findElement(By.id("SubmitLogin"));
        signInBtn.click();
    }
}
