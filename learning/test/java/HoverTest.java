import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HoverTest {
    @Test
    public void actionTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // najechanie na element myszka

        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.tagName("h1"));

        actions.moveToElement(heading).perform();




    }
}
