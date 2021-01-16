import Pages.Pages.Components.ShoppingCartItem;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Pages.*;

import java.util.List;

// Linear Shopping Cart tests for Java
public class POMCartTests {

    @Test
    public void POMAddToCartTest() throws Exception {

        // initialisation
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, 10);
        browser.manage().window().maximize();

        // go to website
        browser.get("http://automationpractice.com/");

        // navigate to login page
        HomePage homePage = new HomePage(browser);
        homePage.navigateToLoginPage()
                .login("arsov.ivaylo@gmail.com", "pass547*")
                .navigateToHomePage()
                .selectProduct(1)
                .addProductToCart()
                .proceedToCheckout()
                .navigateToHomePage()
                .selectProduct(2)
                .addProductToCart()
                .proceedToCheckout();

        // verify we have 1 item in the shopping cart
        ShopingCartSummaryPage shopingCartSummaryPage = new ShopingCartSummaryPage(browser);

        List<ShoppingCartItem> cartItems = shopingCartSummaryPage.getShoppingCart();
        double totalItemsAmount = cartItems.stream().mapToDouble(ShoppingCartItem::getTotalPrice).sum();
        totalItemsAmount = Math.round(totalItemsAmount*100)/100.0d;
        double totalAmount = shopingCartSummaryPage.getTotalPrice();
        assertEquals(totalItemsAmount, totalAmount, "Total value of items does not equal total quoted.");

        browser.quit();
    }
}
