import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutMts {
    private WebDriver driver;

    public AboutMts(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAbout() {
        By clickLocator = By.xpath("a[href='https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(clickLocator));
        element.click();
    }
}