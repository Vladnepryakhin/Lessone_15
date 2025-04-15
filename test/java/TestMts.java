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

public class TestMts {
    private PageMts pageMts;
    private PayMts payMts;
    private AboutMts aboutMts;
    private OplataMts oplataMts;
    private InternetMts internetMts;
    private RasrochkaMts rasrochkaMts;
    private DolgMts dolgMts;
    private WebDriver driver;

    @BeforeAll
    public static void Init1() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Принять']")));
        button.click();
        pageMts = new PageMts(driver);
        payMts = new PayMts(driver);
        oplataMts = new OplataMts(driver);
        internetMts = new InternetMts(driver);
        rasrochkaMts = new RasrochkaMts(driver);
        dolgMts = new DolgMts(driver);
        aboutMts = new AboutMts(driver);
    }

    @AfterEach
    public void Teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testInfo() {
        String title = pageMts.info();
        System.out.println(title);
    }

    @Test
    public void testPay() {
        payMts.pay();
    }

    @Test
    public void testClickAbout() {
        aboutMts.clickAbout();
    }

    @Test
    public void testClickNumber() throws InterruptedException {
            oplataMts.clickNumber("297777777", "100", "nv_slm@mail.ru");
    }
    @Test
    public void testHomeInternet(){
        internetMts.homeInternet();
    }
    @Test
    public void testRassrochka(){
        rasrochkaMts.rassrochka();
    }
    @Test
    public void testDolg(){
        dolgMts.dolg();
    }
}

