import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageMts {
    private WebDriver driver;

    public PageMts(WebDriver driver) {
        this.driver = driver;
    }
    // Получение заголовка
    public String info()  {
        By onlineLocator = By.xpath("//*[@class='pay']//h2");
        Assertions.assertEquals(driver.findElement(onlineLocator).getText(),"Онлайн пополнение\nбез комиссии");
        return driver.findElement(onlineLocator).getText();
    }
    // Logotipy
    public String pay()  {
        By payLocator = By.className("pay__partners");
        WebElement pay = driver.findElement(payLocator);
        return pay.getText();
    }
    // About knopka
    public void clickAbout() {
        By clickLocator = By.xpath("a[href='https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(clickLocator));
        element.click();
    }
    //Zapolnenie oplaty
    public void clickNumber(String number, String sum, String email) throws InterruptedException {
        By nomerLocator = By.xpath("//*[@class='phone']");
        By summaLocator = By.xpath("//*[@id='connection-sum']");
        By pochtaLocator = By.xpath("//*[text()='E-mail для отправки чека']");
        By nextLocator = By.xpath("//*[@id=\"pay-connection\"]/button");
        By frameLocator = By.xpath("/html/body/div[8]/div/iframe");
        By info1Locator = By.xpath("//*[@class='pay-description__cost']");
        By info2Locator = By.xpath("//*[@id='cc-number']");
        By info3Locator = By.xpath("//*[@placeholder='MM / YY']");
        By info4Locator = By.xpath("//*[@autocomplete='cc-name]");
        By info5Locator = By.xpath("//*[@autocomplete='cc-csc]");
        WebElement nomer = driver.findElement(nomerLocator);
        nomer.sendKeys(number);
        WebElement summa = driver.findElement(summaLocator);
        summa.sendKeys(sum);
        WebElement pohta = driver.findElement(pochtaLocator);
        pohta.sendKeys(email);
        WebElement next = driver.findElement(nextLocator);
        next.click();
        Thread.sleep(5000);
        WebElement frameElement = driver.findElement(frameLocator);
        driver.switchTo().frame(frameElement);
        WebElement info1 = driver.findElement(info1Locator);
        System.out.println(info1.getText());
        WebElement info2 = driver.findElement(info2Locator);
        System.out.println(info2.getText());
        WebElement info3 = driver.findElement(info3Locator);
        System.out.println(info3.getText());
        WebElement info4 = driver.findElement(info4Locator);
        System.out.println(info4.getText());
        WebElement info5 = driver.findElement(info5Locator);
        System.out.println(info5.getText());
    }
    //Интернет
    public void homeInternet(){
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
    //Рассрочка
    public void rassrochka(){
        By element1Locator = By.xpath("//*[@class='select_header']");
        By element2Locator = By.xpath("//*[text()='Рассрочка']");
        By nomerLocator = By.xpath("//*[@id='score-instalment']");
        By summaLocator = By.xpath("//*[@id='instalment-sum']");
        By emailLocator = By.xpath("//*[@id='instalment-email']");
        WebElement element1 = driver.findElement( element1Locator);
        element1.click();
        WebElement element2 = driver.findElement(element2Locator);
        element2.click();
        WebElement nomer = driver.findElement(nomerLocator);
        System.out.println(nomer.getText());
        WebElement summa = driver.findElement(summaLocator);
        System.out.println(summa.getText());
        WebElement email = driver.findElement(emailLocator);
        System.out.println(email.getText());
    }
    //Долги
    public void dolg(){
        By element1Locator = By.xpath("//*[@class='select_header']");
        By element2Locator = By.xpath("//*[text()='Задолженность']");
        By nomerLocator = By.xpath("//*[@id='score-arrears']");
        By summaLocator = By.xpath("//*[@id='arrears-sum']");
        By emailLocator = By.xpath("//*[@id='arrears-email']");
        WebElement element1 = driver.findElement(element1Locator);
        element1.click();
        WebElement element2 = driver.findElement(element2Locator);
        element2.click();
        WebElement nomer = driver.findElement(nomerLocator);
        System.out.println(nomer.getText());
        WebElement summa = driver.findElement(summaLocator);
        System.out.println(summa.getText());
        WebElement email = driver.findElement(emailLocator);
        System.out.println(email.getText());
    }
}
