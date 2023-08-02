package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day13_ReusableMethods extends TestBase {
//    When user goes to https://www.automationexercise.com/
//    And click on Sing up link
//    And enter credentials and click sign up button
//    And enter the information
//    And click on Create Account
//    Then verify the account creating is successful. Account Created! Element is displayed
//    GOAL: Use Reusable Methods only.
    @Test
    public void signUpTest(){
//        driver.get("https://www.automationexercise.com/");
        openURL("https://www.automationexercise.com/");
//        driver.findElement(By.linkText("Signup / Login")).click();
        clickWithTimeoutByJS(driver.findElement(By.linkText("Signup / Login")));
//        driver.findElement(By.name("name")).sendKeys("johnny");
//        driver.findElement(By.name("email")).sendKeys("johnny0090@gmail.com");
//        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        sendKeysWithTimeout(driver.findElement(By.name("name")),"johnny",5);
        sendKeysWithTimeout(driver.findElement(By.name("email")),"johnny0090@gmail.com",5);
        clickWithTimeoutByJS(driver.findElement(By.xpath("//button[@data-qa='signup-button']")));
    }
}
