package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Day02_FirefoxBrowserTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.firefox.driver", "/Users/eozer1/Selenium Libraries/drivers");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.quit();
    }

}
