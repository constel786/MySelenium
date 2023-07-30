package com.myfirstproject.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    //Create these 3 Extent Reports Objects
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetup(){
        //These steps must be executed before each class so report generating happens

        // Type a dynamic name for report --> The report will be saved in Reports folder
        String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Reports/extent-reprts" + now + ".html";
        //the html report will be saved in this path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //create extent reports object so the report template can be generated
        extentReports = new ExtentReports();

        // *** Optionally Add Custom System Information ***
        extentReports.setSystemInfo("Project Name","Techpro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Environment","Regression");
        extentReports.setSystemInfo("Team Name","TechPro");
        extentReports.setSystemInfo("SQA","John");

        // *** Optionally Add Document Information ***
        extentHtmlReporter.config().setDocumentTitle("My Extent Report");
        extentHtmlReporter.config().setReportName("My Regression Report");

        //Attach the extentHtmlReporter
        extentReports.attachReporter(extentHtmlReporter);

        //Create extentTest
        extentTest = extentReports.createTest("TechPro Education Regression Report","TechPro team report");

    }

    @AfterClass
    public static void tearDonwReport(){
        //flush() method is required to generate the report
        extentReports.flush();
    }

    //Test Base is used to run @Before and @After classes automatically in the child classes
    protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    //    WebDriverManager.firefoxdriver().setup();  //FOR FIREFOX If I GET CAPTCHA ON PAGE
    //    driver = new FirefoxDriver();
    //    WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*")); //IF I HAVE A VERSION ISSUE
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
    driver.quit();
    }

    //The method to take screenshot entire page
    public void captureScreenshotEntirePage() {
        //1. Step: Convert drive to TakesScreenshot by type casting and use getScreenshotAs() method
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //2. Step: Type a dynamic name for screenshots images
        String time = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir")+"/test-output/Screenshot/"+time+".png";
        //String path = "/Users/eozer1/Selenium Projects/MySeleniumProject"+"/test-output/Screenshot"+time+".png";

        //3. Step: Save the image in the path
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //This method will be used to attach the screenshots in the automation reports
    //This method captures the screenshot and returns the screenshot path as String
    //so that we can attach the screenshots in our reports
    public static String captureScreenshotEntirePageAsString() {
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+now+".png";
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //5. Return the absolute path of the image path that is a String
        return new File(path).getAbsolutePath();
    }

    //This method captures the screenshot of a specific element
    //@param: WebElements
    public void captureScreenshotElement(WebElement element) {
        //1. getScreenshotAs() method to capture the screenshot of the element
        //this is the only difference between capturing the entire page and a specific element
        File image = element.getScreenshotAs(OutputType.FILE);

        //2. Step: Type a dynamic name for screenshots images
        String time = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir")+"/test-output/ElementScreenshot/"+time+"image.png";
        //String path = "/Users/eozer1/Selenium Projects/MySeleniumProject"+"/test-output/Screenshot"+time+".png";

        //3. Step: Save the image in the path
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//      JS EXECUTOR METHODS
    /*
    Click with JS
    param: WebElement
    action: clicks on the given element
     */
    public static void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    /*
    Scroll into specific elements
    param: WebElement
    action: scrolls into the given element
     */
    public static void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    /*
    Scroll all the way to the bottom
     */
    public static void scrollAllDownJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    /*
    Scroll all the way to the top
     */
    public static void scrollAllUpJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }
}
