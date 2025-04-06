import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testMts {
    private PageMts pageMts;
    private WebDriver driver;

    @BeforeAll
    public static void init1() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Принять']")));
        button.click();
        pageMts = new PageMts(driver);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testInfo() {
        String title = pageMts.Info();
        System.out.println(title);
    }

    @Test
    public void testPay() {
        pageMts.Pay();
    }

    @Test
    public void testClickAbout() {
        pageMts.ClickAbout();
    }

    @Test
    public void testClickNumber() throws InterruptedException {
            pageMts.ClickNumber("297777777", "100", "nv_slm@mail.ru");
    }
    @Test
    public void testHomeInternet(){
        pageMts.HomeInternet();
    }
    @Test
    public void testRassrochka(){
        pageMts.Rassrochka();
    }
    @Test
    public void testDolg(){
        pageMts.Dolg();
    }
}

