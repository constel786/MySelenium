package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Day12_FluentWait extends TestBase {

    @Test
    public void FluentWait(){
//        Create a class:ExplicitWait
//        Create a method: explicitWait
//        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        //1. Create object
        Wait<WebDriver> wait = new FluentWait<>(driver) //creating Wait object
                .withTimeout(Duration.ofSeconds(15)) //adding max timeout
                .pollingEvery(Duration.ofSeconds(2)) //adding interval, how often the driver checks the element
                .withMessage("Ignoring no such element exception") //adding custom message
                .ignoring(NoSuchElementException.class); //ignoring NoSuchElementException exception

        //2. Use the object to handle the wait issue
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
//        Then verify the ‘Hello World!’ Shows up on the screen
        Assert.assertEquals("Hello World!", helloWorld.getText());



    }
}
