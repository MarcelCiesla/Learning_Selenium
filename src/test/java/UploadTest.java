import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class UploadTest {

    @Test
    public void uploadFile() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        int randomnumber = (int) (Math.random()*1000);
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        // robienie screena
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String fileName = "beforeupload" + randomnumber + ".png";
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(before, new File("src/test/resources/" + fileName));
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Marcel\\Desktop\\programowanie\\sample.txt.txt");
        String fileName2 = "afterupload" + randomnumber + ".png";
        File after = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(after, new File("src/test/resources/" + fileName2));


        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();


    }

}
