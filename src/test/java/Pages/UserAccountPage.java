package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAccountPage extends BasePage {


    public UserAccountPage(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
        waitForPageTitle("Login - ");
    }


}
