import org.openqa.selenium.InvalidArgumentException;
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

        WebDriver driver = getDriver("ie");
        driver.get("https://www.google.com");
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
