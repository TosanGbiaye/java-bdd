package pagerunner;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginPageSteps {
    Dotenv env = Dotenv.load();

    Selectors sel;
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void set_up() {        //method
        driver.get(env.get("URL"));
        driver.manage().window().maximize();
    }

    public void tear_down() {      //method
        driver.quit();
    }

    public void insert_a_text(String text_Field, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text_Field)));
        driver.findElement(By.cssSelector(text_Field)).sendKeys(text);

    }

    private void verify_page(String element, String expected_text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
        String pageTitle = driver.findElement(By.cssSelector(element)).getText();
        Assert.assertEquals(pageTitle, expected_text);
    }

    public void insert_password() {
        this.insert_a_text(sel.passwordField, sel.password);
    }

    public void click_login_button() {
        driver.findElement(By.cssSelector(sel.loginButton)).click();
    }

    public void view_products_page() {
        this.verify_page(sel.productHeader, sel.productTitle);
    }

    public void view_similar_images() {
        List<WebElement> images = driver.findElements(By.cssSelector(sel.similarImages));
        for (WebElement i : images) {
            Assert.assertEquals(i.getAttribute("src"), sel.imageSource);
        }
    }

    public void view_error_message() {
        this.verify_page(sel.errorBanner, sel.errorMessage);
    }

}
