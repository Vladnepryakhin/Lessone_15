import org.example.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
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

    @BeforeSuite
    public void Init1() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Принять']")));
            button.click();
        } catch (Exception e) {
            System.out.println("Кнопка 'Принять' не найдена, продолжение без клика");
        }

        pageMts = new PageMts(driver);
        payMts = new PayMts(driver);
        oplataMts = new OplataMts(driver);
        internetMts = new InternetMts(driver);
        rasrochkaMts = new RasrochkaMts(driver);
        dolgMts = new DolgMts(driver);
        aboutMts = new AboutMts(driver);
    }

    @AfterMethod
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
    public void testClickAbout() throws InterruptedException {
        aboutMts.clickAbout();
    }

    @Test
    public void testClickNumber() throws InterruptedException {
        oplataMts.clickNumber("297777777", "100", "nv_slm@mail.ru");
    }

    @Test
    public void testHomeInternet() {
        internetMts.HomeInternet();
    }

    @Test
    public void testRassrochka() {
        rasrochkaMts.rassrochka();
    }

    @Test
    public void testDolg() {
        dolgMts.dolg();
    }
}
