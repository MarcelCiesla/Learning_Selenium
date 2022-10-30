package pl.testeroprogramowania;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Listeners(value = {SampleTestListener.class})
public class ThirdTest extends BaseTest {

    // sprawdzanie czy obrazek na stronie został poprawnie załadowany poprzez wysokosc obrazka
    WebDriver driver;

    @Test //@Ignore do ignorowania
    public void firstTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        waitForElementToExist(By.cssSelector("p"));

        WebElement para = driver.findElement(By.cssSelector("p"));

        // twarda asercja test kończy się na pierwszej błędnej asercji

        Assert.assertEquals(para.isDisplayed(), true);
        Assert.assertTrue(para.isDisplayed(),"Element is not displayed");
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertEquals(para.getText(),"Dopiero","Teksty są różne");
        Assert.assertFalse(para.getText().startsWith("Pojawiłem"));
        Assert.assertEquals(para.getText(),"Dopiero się pojawiłem!");
        driver.quit();

    }

    @Test @Ignore
    public void secondTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        waitForElementToExist(By.cssSelector("p"));
        WebElement para = driver.findElement(By.cssSelector("p"));

        SoftAssert softAssert = new SoftAssert();

        // miękka asercja czyli sprawdzenie kilka rzeczy i podsumowanie pod sam koniec

        softAssert.assertEquals(para.isDisplayed(), true);
        softAssert.assertTrue(para.isDisplayed(),"Element is not displayed");
        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertEquals(para.getText(),"Dopiero","Teksty są różne");
        softAssert.assertFalse(para.getText().startsWith("Pojawiłem"));
        softAssert.assertEquals(para.getText(),"Dopiero się","Druga asercja");

        driver.quit();
        softAssert.assertAll();

    }

    public void waitForElementToExist (By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        /*wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = driver.findElements(locator);
                if(elements.size()>0) {
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Elementu nie ma na stronie");
                    return false;
                }
            }
        });*/
        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Elementu nie ma na stronie");
                return false;
            }
        });
    }

}
