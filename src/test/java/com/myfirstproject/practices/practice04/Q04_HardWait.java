package com.myfirstproject.practices.practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class Q04_HardWait extends TestBase {
//Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
//Click on "click me" button
//Verify that "Event Triggered"
@Test
    public void hardWait() throws InterruptedException {
    driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
    Thread.sleep(4000); //Waiting for button to fully grow in size
    driver.findElement(By.id("growbutton")).click(); //implicit wait will not work here
    assertTrue(driver.findElement(By.id("growbuttonstatus")).isDisplayed());

}

}
