package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_AccountCreation {
    /*  1. Launch browser - DONE IN setUp
        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"));
        4. Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();
        WebElement signUpLink = driver.findElement(By.partialLinkText("Signup / Login"));
        signUpLink.click();
        automationexercise.com
        Automation Exercise
        This is for automation practice
    */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void accountCreationTest(){
        driver.get("https://www.automationexercise.com");
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"));
        driver.findElement(By.partialLinkText("Signup / Login")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed());
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Johnny Walker");

    }
}
