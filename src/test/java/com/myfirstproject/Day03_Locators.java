package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Locators {
    WebDriver driver;
    @Before
    public void setUp(){
        //@Before method will be used for preconditions
        WebDriverManager.chromedriver().setup(); //setting up the driver
        driver = new ChromeDriver(); //creating Chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //adding implicit wait
        driver.manage().window().maximize(); //maximizing window
    }
    @Test
    public void locatorsTest() throws InterruptedException {
//When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//And enter username
    WebElement username = driver.findElement(By.name("username"));
    username.sendKeys("Admin");
//And enter password
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("admin123");
//And click on submit button
    WebElement loginButton = driver.findElement(By.tagName("button"));
    loginButton.click();
//Then verify the login is successful
    //1. If login is successful, then the URL must contain "dashboard"
    //2. If login is successful, then a core element <p class="oxd-userdropdown-name" data-v-bdd6d943="">PaulBarak CollingsAvital</p> should be displayed

    //1. Verifying login using the URL
    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard")); //or
    Assert.assertFalse(driver.getCurrentUrl().contains("auth")); //URL no longer should contain "auth"

    //2. Verifying login using a core element
    Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed()); //If displayed returns TRUE, and if not displayed returns FALSE
//Then logout the application
    WebElement theGuy = driver.findElement(By.className("oxd-userdropdown-name"));
    theGuy.click();
    //Thread.sleep(5000); to wait a little
    WebElement logOutLink = driver.findElement(By.linkText("Logout")); //We can use linkText or partialLinkText
    logOutLink.click();
//Then verify the logout is successful
    Assert.assertTrue(driver.getCurrentUrl().contains("auth")); //or
    Assert.assertFalse(driver.getCurrentUrl().contains("dashboard")); //since "dashboard" is in login page, or core element:
    // If header is displayed on the page then logout is successful
    // <h5 class="oxd-text oxd-text--h5 orangehrm-login-title" data-v-7b563373="" data-v-358db50f="">Login</h5>
    //Assert.assertTrue(driver.findElement(By.className("oxd-text oxd-text--h5 orangehrm-login-title")).isDisplayed()); DID NOT WORK due to space in the middle
        Assert.assertTrue(driver.findElement(By.tagName("h5")).isDisplayed());

        boolean isHeaderDisplayed = driver.findElement(By.tagName("h5")).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed);

    Assert.assertTrue(driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).isDisplayed());

    }
}
