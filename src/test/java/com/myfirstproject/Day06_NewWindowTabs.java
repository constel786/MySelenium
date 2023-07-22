package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class Day06_NewWindowTabs extends TestBase {

    @Test
    public void newTabTest() throws InterruptedException {

        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String window1Handle = driver.getWindowHandle();
        System.out.println("Window 1 = " + window1Handle);
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.ebay.com");
        String eBayWindowHandle = driver.getWindowHandle();
        System.out.println("Window 2 = " + eBayWindowHandle);
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        Thread.sleep(5000);
        //At this point the driver is on the eBay tab
        driver.switchTo().window(window1Handle);
        System.out.println("Linkedin Title " + driver.getTitle());
        Thread.sleep(5000);
        driver.switchTo().window(eBayWindowHandle);
        System.out.println("eBay Title " +driver.getTitle());
        Thread.sleep(5000);

    }

    @Test
    public void newWindowTest() throws InterruptedException {

        driver.get("https://www.linkedin.com");
        //Assert.assertTrue(driver.getTitle().contains("Linkedin"));
        String window1Handle = driver.getWindowHandle();
        System.out.println("Window 1 = " + window1Handle);
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.ebay.com");
        String eBayWindowHandle = driver.getWindowHandle();
        System.out.println("Window 2 = " + eBayWindowHandle);
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        Thread.sleep(5000);
        //At this point the driver is on the eBay tab
        driver.switchTo().window(window1Handle);
        System.out.println("Linkedin Title " + driver.getTitle());
        Thread.sleep(5000);
        driver.switchTo().window(eBayWindowHandle);
        System.out.println("eBay Title " +driver.getTitle());
        Thread.sleep(5000);

    }
}
