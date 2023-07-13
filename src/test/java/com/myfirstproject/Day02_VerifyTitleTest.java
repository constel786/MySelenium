package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //Verify if page title contains "Amazon"
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Amazon";
        if (actualPageTitle.contains(expectedPageTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualPageTitle = " + actualPageTitle);
            System.out.println("But expected title is Amazon.");
            System.out.println("Actual title does not contain Amazon");
        }
        driver.quit();

    }
}
