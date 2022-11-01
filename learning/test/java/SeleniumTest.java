import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marcel\\Desktop\\programowanie\\chromedriver\\chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\Marcel\\Desktop\\programowanie\\firefoxdriver\\geckodriver.exe");
        //System.setProperty("webdriver.ie.driver", "C:\\Users\\Marcel\\Desktop\\programowanie\\internetexplorerdriver\\IEDriverServer.exe");
        //WebDriver driver = new InternetExplorerDriver();
        //driver.get("https://www.google.com");

        WebDriver driver = getDriver("chrome");
        //driver.manage().window().maximize();   przegladarka na full screena
        Dimension windowSize = new Dimension(200, 200);  // narzucenie wielkości okna przeglądarki
        driver.manage().window().setSize(windowSize);
        driver.get("https://www.google.com");   // otwieranie konkretnej strony

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.google.com','blank','height=200,width=200')");

        // pytanie na rozmowie czym się rózni driver.close od driver.quit
        //driver.close();  // zamyka tylko konkretne okno
        driver.quit(); // zamyka wszystko
    }

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                String chromePath = "C:\\Users\\Marcel\\Desktop\\programowanie\\chromedriver\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromePath);
                return new ChromeDriver();
            case "firefox":
                String firefoxPath = "C:\\Users\\Marcel\\Desktop\\programowanie\\firefoxdriver\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", firefoxPath);
                return new FirefoxDriver();
            case "ie":
                String iePath = "C:\\Users\\Marcel\\Desktop\\programowanie\\internetexplorerdriver\\IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", iePath);
                return new InternetExplorerDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }


    }

}
