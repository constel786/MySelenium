package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Day02_WebDriverManagerTest {
    public static void main(String[] args) {

        //WebDriverManager: This is an API that is used to setup the drivers instead of System.setProperty().
/*
        //Testing on Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.close();

        //Testing on Firefox
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://www.amazon.com");
        firefox.close();


 */
        //Testing on Safari
        WebDriverManager.safaridriver().setup();
        WebDriver safari = new SafariDriver();
        safari.get("https://www.amazon.com");
        safari.close();

    }
}
