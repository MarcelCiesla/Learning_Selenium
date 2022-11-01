import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {


    @Test
    public void findElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("Pierwszy");

        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By cssClas2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClas2);

        By all = By.cssSelector("*");   // pokazuje wszystkie
        driver.findElements(all);

        By ulInDiv = By.cssSelector("div ul");
        By trINTable = By.cssSelector("table tr");
        By trInBody = By.cssSelector("tbody tr");

        driver.findElement(ulInDiv);
        driver.findElement(trINTable);
        driver.findElement(trInBody);

        By firstChildUlinDiv = By.cssSelector("div > ul");
        By firstChildTrinbody = By.cssSelector("tbody > tr");

        driver.findElement(firstChildUlinDiv);
        driver.findElement(firstChildTrinbody);

        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firstFormAfterLabel);
        driver.findElement(allFormAfterLabel);

        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("[name*='name']");
        By attrStarts = By.cssSelector("[name^='f']");
        By attrEnds = By.cssSelector("[name$='name']");

        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By secondChild = By.cssSelector("li:nth-child(2)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(secondChild);




    }
}
