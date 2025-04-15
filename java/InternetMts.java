import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternetMts {
    private WebDriver driver;

    public InternetMts(WebDriver driver) {
        this.driver = driver;
    }

    public void HomeInternet() {
        By element1Locator = By.xpath("//*[@class='select_header']");
        By element2Locator = By.xpath("//*[text()='Домашний интернет']");
        By phoneLocator = By.xpath("//*[@id='internet-phone']");
        By sumLocator = By.xpath("//*[@id='internet-sum']");
        By emailLocator = By.xpath("//*[@id='internet-email']");
        WebElement element1 = driver.findElement(element1Locator);
        element1.click();
        WebElement element2 = driver.findElement(element2Locator);
        element2.click();
        WebElement phone = driver.findElement(phoneLocator);
        System.out.println(phone.getText());
        WebElement sum = driver.findElement(sumLocator);
        System.out.println(sum.getText());
        WebElement email = driver.findElement(emailLocator);
        System.out.println(email.getText());
    }
}