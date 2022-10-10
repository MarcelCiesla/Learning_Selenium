import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class IframeTest {

    @Test
    public void testNewWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        // za pomoca webelementu
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);

        // jeszcze jest mozliwosc za pomoca name i id

        //za pomoca inta
        //driver.switchTo().frame(0);

        driver.findElement(By.id("fname")).sendKeys("Marcel");
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());







    }
}
