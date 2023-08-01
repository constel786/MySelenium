package com.myfirstproject;

import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day12_StaleElementReferenceException extends TestBase {

    @Test
    public void staleElementReferenceExceptionTest() throws InterruptedException {
        LoggerUtils.info("Navigating to the amazon home page..");
        driver.get("https://www.amazon.com");
        LoggerUtils.info("Searching for tea pot...");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("tea pot");
        LoggerUtils.info("Clicking on the Best Sellers link....");
        Thread.sleep(2000);
//        Going to Account page
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        Thread.sleep(1000);
        WebElement accountLink = driver.findElement(By.linkText("Account"));
        actions.click(accountLink).perform();


//        And navigating back to the home page
        LoggerUtils.info("Going back to the Amazon home page...");
        driver.navigate().back();//going back to home page. page elements are no longer fresh. StaleElementReferenceException
        Thread.sleep(2000);
//        driver.navigate().refresh();//page elements are now slate no longer fresh. StaleElementReferenceException
        LoggerUtils.info("Searching for iphone...");
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));//solution is relocating the element
        searchBox.sendKeys("iPhone");
    }
}
