import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Pages.*;

// Linear Shopping Cart tests for Java
public class POMCartTests {

    @Test
    public void POMAddToCartTest() {

        // initialisation
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, 10);
        browser.manage().window().maximize();

        // go to website
        browser.get("http://automationpractice.com/");

        // navigate to login page
        HomePage homePage = new HomePage(browser);
        homePage.navigateToLogIn();

        // log in
        LoginPage loginPage = new LoginPage(browser);
        loginPage.setEmailAddress("arsov.ivaylo@gmail.com");
        loginPage.setPassword("pass547*");
        loginPage.clickSignInBtn();

        // navigate back to home page
        UserAccountPage userAccountPage = new UserAccountPage(browser);
        userAccountPage.backToHomePage();

        // select the first product
        List<WebElement> productNameLinks = homePage.getProductNameLinks();
        productNameLinks.get(0).click();

        // add 1 item to the shopping cart
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(browser);
        productDetailsPage.addProductToCart();

        // proceed to checkout
        AddToCartConfirmationPopUp addToCartConfirmationPopUp = new AddToCartConfirmationPopUp(browser);
        addToCartConfirmationPopUp.confirmAddToCart();

        // verify we have 1 item in the shopping cart
        ShopingCartSummaryPage shopingCartSummaryPage = new ShopingCartSummaryPage(browser);
        int numProducts = shopingCartSummaryPage.getQuantityOfCheckoutProducts();

        assertEquals(numProducts, 1, "Expected number of products in shopping cart was 1 but actual value was: " + Integer.toString(numProducts));

        browser.quit();
    }
}
