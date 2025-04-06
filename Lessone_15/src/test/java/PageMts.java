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
    public String Info()  {
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@class='pay']//h2")).getText(),"Онлайн пополнение\nбез комиссии");
        return driver.findElement(By.xpath("//*[@class='pay']//h2")).getText();
    }
    // Logotipy
    public String Pay()  {
        WebElement pay = driver.findElement(By.className("pay__partners"));
        return pay.getText();
    }
    // About knopka
    public void ClickAbout() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("a[href='https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']")));
        element.click();
    }
    //Zapolnenie oplaty
    public void ClickNumber(String number, String sum, String email) throws InterruptedException {
        WebElement nomer = driver.findElement(By.xpath("//*[@class='phone']"));
        nomer.sendKeys(number);
        WebElement summa = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        summa.sendKeys(sum);
        WebElement pohta = driver.findElement(By.xpath("//*[text()='E-mail для отправки чека']"));
        pohta.sendKeys(email);
        WebElement next = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        next.click();
        Thread.sleep(5000);
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[8]/div/iframe"));
        driver.switchTo().frame(frameElement);
        WebElement info1 = driver.findElement(By.xpath("//*[@class='pay-description__cost']"));
        System.out.println(info1.getText());
        WebElement info2 = driver.findElement(By.xpath("//*[@id='cc-number']"));
        System.out.println(info2.getText());
        WebElement info3 = driver.findElement(By.xpath("//*[@placeholder='MM / YY']"));
        System.out.println(info3.getText());
        WebElement info4 = driver.findElement(By.xpath("//*[@autocomplete='cc-csc]"));
        System.out.println(info4.getText());
        WebElement info5 = driver.findElement(By.xpath("//*[@autocomplete='cc-name]"));
        System.out.println(info5.getText());
    }
    //Nam vash internet nahyi ne nyzhon
    public void HomeInternet(){
        WebElement element1 = driver.findElement(By.xpath("//*[@class='select_header']"));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//*[text()='Домашний интернет']"));
        element2.click();
        WebElement phone = driver.findElement(By.xpath("//*[@id='internet-phone']"));
        System.out.println(phone.getText());
        WebElement sum = driver.findElement(By.xpath("//*[@id='internet-sum']"));
        System.out.println(sum.getText());
        WebElement email = driver.findElement(By.xpath("//*[@id='internet-email']"));
        System.out.println(email.getText());
    }
    //RasrOCHKA
    public void Rassrochka(){
        WebElement element1 = driver.findElement(By.xpath("//*[@class='select_header']"));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//*[text()='Рассрочка']"));
        element2.click();
        WebElement nomer = driver.findElement(By.xpath("//*[@id='score-instalment']"));
        System.out.println(nomer.getText());
        WebElement summa = driver.findElement(By.xpath("//*[@id='instalment-sum']"));
        System.out.println(summa.getText());
        WebElement email = driver.findElement(By.xpath("//*[@id='instalment-email']"));
        System.out.println(email.getText());
    }
    //Ya opyat' v dolgi eti lezy
    public void Dolg(){
        WebElement element1 = driver.findElement(By.xpath("//*[@class='select_header']"));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//*[text()='Задолженность']"));
        element2.click();
        WebElement nomer = driver.findElement(By.xpath("//*[@id='score-arrears']"));
        System.out.println(nomer.getText());
        WebElement summa = driver.findElement(By.xpath("//*[@id='arrears-sum']"));
        System.out.println(summa.getText());
        WebElement email = driver.findElement(By.xpath("//*[@id='arrears-email']"));
        System.out.println(email.getText());
    }
}
