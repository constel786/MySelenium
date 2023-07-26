package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day09_CaptureScreenshotElement extends TestBase {
    @Test
    public void captureScreenshotElementsTest(){
        driver.get("https://www.google.com");
        WebElement googleImage = driver.findElement(By.xpath("//img[@alt='Google']"));
        captureScreenshotElement(googleImage); //this is new here and it works!!
        captureScreenshotEntirePage(); //Can do this too

    }
}
