package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions2 extends TestBase {
    @Test
    public void dragAndDropTest(){

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0); //or ALTERNATIVELY
        // WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        // driver.switchTo().frame(frameElement);

        WebElement target = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(target, destination).perform();

    }
}
