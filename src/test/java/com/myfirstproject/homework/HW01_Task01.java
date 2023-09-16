package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class HW01_Task01 extends TestBase {
//    Task1:
//    Navigate to Go to https://www.facebook.com/
//    Click on Create new account
//    Enter first name
//    Enter last name
//    Enter mobile number or email
//    Enter new password
//    Enter birthday
//    Enter gender
//    Click Sign Up

    @Test
    public void task01(){
        driver.get("https://www.facebook.com/ ");
        //driver.findElement(By.xpath("//div//a[@id='u_0_0_5p']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("James");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Brown");
        driver.findElement(By.cssSelector("input[id='u_b_g_ih']")).sendKeys("+12403980966");
        driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Sifremolsun1234");

    }
}
