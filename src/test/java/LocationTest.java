import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationTest {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(java.nio.file.Paths.get("test-results/videos")));
        page = context.newPage();
    }

    @AfterEach
    public void tearDown() {
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @Test
    public void testLoginSearchChangeSelectLogout() throws InterruptedException {
        page.navigate("file://" + System.getProperty("user.dir") + "/src/main/resources/index.html");

        // Login
        page.fill("#username", "testuser");
        Thread.sleep(2000);
        page.fill("#password", "password");
        Thread.sleep(2000);
        page.click("#login-btn");
        Thread.sleep(2000);

        // OTP Verification
        Thread.sleep(2000);
        page.fill("#otp", "123456");
        Thread.sleep(2000);
        page.click("#verify-otp-btn");
        Thread.sleep(3000);

        // Search location
        Thread.sleep(2000);
        page.fill("#search-input", "london");
        Thread.sleep(2000);
        page.click("#search-btn");
        Thread.sleep(3000);

        // Change location
        page.click("#change-location-btn");
        Thread.sleep(3000);

        // Select location
        page.click("#select-location-btn");
        Thread.sleep(3000);

        // Logout
        page.click("#logout-btn");
        Thread.sleep(2000);

        // Verify back to login
        assertTrue(page.isVisible("#login-form"));
    }
}
