package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSourceTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        String actualPageSource = driver.getPageSource();
        if (actualPageSource.contains("Registry")){
            System.out.println("PASS");
        }else {
            System.out.println("PASS");
            System.out.println("Page Source does not contain 'Registry'");
        }
        driver.quit();

    }
}
