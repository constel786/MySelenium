package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "/Users/eozer1/Selenium Libraries/drivers/chromedriver_mac64");

        WebDriverManager.chromedriver().setup(); //setup the driver
        WebDriver driver = new ChromeDriver(); //create the driver
        driver.get("https://www.amazon.com/"); //automate

    }
}
