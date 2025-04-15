import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageMts {
    private WebDriver driver;

    public PageMts(WebDriver driver) {
        this.driver = driver;
    }
    public String info()  {
        By onlineLocator = By.xpath("//*[@class='pay']//h2");
        Assertions.assertEquals(driver.findElement(onlineLocator).getText(),"Онлайн пополнение\nбез комиссии");
        return driver.findElement(onlineLocator).getText();
    }
}
