package pl.testeroprogramowania;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class SampleTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am starting test");
    }
@Override
    public void onTestSuccess(ITestResult result) {
    }
@Override
    public void onTestFailure(ITestResult result) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    int randomnumber = (int) (Math.random()*1000);
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File before = screenshot.getScreenshotAs(OutputType.FILE);
    String fileName = "failedTest" + randomnumber + ".png";
    try {
        FileUtils.copyFile(before, new File("src/test/resources/" + fileName));
    } catch (IOException e) {
        e.printStackTrace();
    }

}
@Override
    public void onTestSkipped(ITestResult result) {
    }
@Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
@Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }
@Override
    public void onStart(ITestContext context) {
    }
@Override
    public void onFinish(ITestContext context) {
    }

}
