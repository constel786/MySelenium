package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigations {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.walmart.com/");
        driver.navigate().to("https://www. amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.quit();

        /*
        1. What is the difference between get() and navigate().to()?
        -Similarities : both are used to go to a URL
        -get() is shorter and easier to use
        -get() accepts only a string parameter; however navigate().to() accepts either a string or URL object in the parameter
        -navigate() has more options such as to(), back(), forward(), and refresh().

        2. What is the difference between close() and quit()?
        -close() closes only the last active browser
        -quit() closes all active browsers
        -I prefer to use quit() to close all browsers after my test case
         */
    }
}