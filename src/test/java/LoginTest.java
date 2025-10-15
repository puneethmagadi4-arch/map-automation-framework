import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginSearchChangeSelectLogout() throws InterruptedException {
        driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        // Login
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("testuser");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");
        Thread.sleep(2000);
        WebElement loginBtn = driver.findElement(By.id("login-btn"));
        loginBtn.click();
        Thread.sleep(2000);

        // OTP Verification
        Thread.sleep(2000); // Wait for OTP section
        WebElement otp = driver.findElement(By.id("otp"));
        otp.sendKeys("123456");
        Thread.sleep(2000);
        WebElement verifyOtpBtn = driver.findElement(By.id("verify-otp-btn"));
        verifyOtpBtn.click();
        Thread.sleep(3000);

        // Search location
        Thread.sleep(2000);
        WebElement searchInput = driver.findElement(By.id("search-input"));
        searchInput.sendKeys("london");
        Thread.sleep(2000);
        WebElement searchBtn = driver.findElement(By.id("search-btn"));
        searchBtn.click();
        Thread.sleep(3000);

        // Change location
        WebElement changeLocationBtn = driver.findElement(By.id("change-location-btn"));
        changeLocationBtn.click();
        Thread.sleep(3000);

        // Select location
        WebElement selectLocationBtn = driver.findElement(By.id("select-location-btn"));
        selectLocationBtn.click();
        Thread.sleep(3000);

        // Logout
        WebElement logoutBtn = driver.findElement(By.id("logout-btn"));
        logoutBtn.click();
        Thread.sleep(2000);

        // Verify back to login
        assertTrue(driver.findElement(By.id("login-form")).isDisplayed());
    }
}
