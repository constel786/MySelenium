package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class Day05_Alerts_Windows_IFrames extends TestBase {
    @Test
    public void alertWindowsIframeTest1(){
//        Given Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
//        Then Assert that "Left List Item 29" is the last element in the "Left"
        /*
        Left List Item 29 element is inside an iframe.
        driver must be switched in this iframe first
        Otherwise driver can not find that element
        1. index --> driver.switchTo().frame(0)
        2. id or name -->  driver.switchTo().frame("left")
        3. webelement --> driver.switchTo().frame(  driver.findElement(By.xpath("//frame[@name='left']"))  );
         */
        driver.switchTo().frame("left");
        //getting all list items in this iframe
        List<WebElement> leftFrameListItems =  driver.findElements(By.xpath("//li"));
        for (WebElement each : leftFrameListItems){
            System.out.println(each);
        }
        WebElement lastLeftItem = leftFrameListItems.get(leftFrameListItems.size()-1);
        Assert.assertEquals("Expected and Actual Not Equal","Left List Item 29", lastLeftItem.getText()); //message will only show up if test case fails
//        And Assert that "Middle List Item 39" is the last element in the "Middle"
    }
}
