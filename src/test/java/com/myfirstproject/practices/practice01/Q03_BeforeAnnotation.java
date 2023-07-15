package com.myfirstproject.practices.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;

public class Q03_BeforeAnnotation {
    // Create chrome driver by using @Before annotation and WebDriverManager
// Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculator under Micro Apps
// Type any number in the first input
// Type any number in the second input
// Click on Calculate
// Get the result
// Verify the result
// Print the result
// Close the browser by using @After annotation

WebDriver driver;
@Before
public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Dynamic wait
}

@Test
    public void test01(){
    driver.get("https://testpages.herokuapp.com/styled/index.html");
    driver.findElement(By.id("calculatetest")).click();
    String input1 = "6";
    driver.findElement(By.id("number1")).sendKeys(input1);
    String input2 = "4";
    driver.findElement(By.id("number2")).sendKeys(input2);
    driver.findElement(By.id("calculate")).click();
    String result = driver.findElement(By.id("answer")).getText();
    assertEquals(Integer.parseInt(input1)+Integer.parseInt(input2)+"", result); //verifying the result. Could hae used "valueOf" instead of "parseInt" also
    assertEquals(Integer.parseInt(input1)+Integer.parseInt(input2), Integer.parseInt(result)); //or this way

    assertEquals(String.valueOf(Integer.parseInt(input1)+Integer.parseInt(input2)), result); //or compare as String

    System.out.println("result = " + result);
}

@After
    public void tearDown() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
}
}
