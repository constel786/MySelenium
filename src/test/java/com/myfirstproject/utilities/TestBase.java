package com.myfirstproject.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    //Test Base is used to run @Before and @After classes automatically in the child classes
    protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    //    WebDriverManager.firefoxdriver().setup();  FOR FIREFOX If I GET CAPTCHA ON PAGE
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
    public void captureScreenshotEntirePage() throws IOException {
        //1. Step: Convert drive to TakesScreenshot by type casting and use getScreenshotAs() method
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //2. Step: Type a dynamic name for screenshots images
        String time = new SimpleDateFormat("yyyyMMddmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir")+"/test-output/Screenshot"+time+".png";

        //3. Step: Save the image in the path
        FileUtils.copyFile(image, new File(path));

    }
}
