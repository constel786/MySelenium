package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyURLTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.amazon.com";

        if (actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualURL = " + actualURL);
            System.out.println("But expected URL is https://www.amazon.com");
        }

        driver.quit();


    }
}
