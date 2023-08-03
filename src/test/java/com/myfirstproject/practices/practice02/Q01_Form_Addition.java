package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertTrue;

public class Q01_Form_Addition extends TestBase {
    @Test
    public void formAdditionTest() throws InterruptedException {
        driver.get("https://phptravels.com/demo");
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Ali");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Veli");
        driver.findElement(By.xpath("//input[@name='business_name']")).sendKeys("Astrodynamics");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ali.veli@astro.com");

        int num1 = Integer.parseInt(driver.findElement(By.id("numb1")).getText());
        int num2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());
        int total = num1 + num2;
        driver.findElement(By.cssSelector("input[id='number']")).sendKeys(total+"");
        //Thread.sleep(500);
        driver.findElement(By.id("demo")).click();
        Thread.sleep(3000);
        String successMessage = driver.findElement(By.cssSelector("p[class='text-center cw']")).getText();
        assertTrue(successMessage.contains("We have sent your demo"));
    }
}
