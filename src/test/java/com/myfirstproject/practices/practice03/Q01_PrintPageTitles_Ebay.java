package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q01_PrintPageTitles_Ebay extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.ebay.com");
        driver.findElement(By.linkText("Electronics")).click();
        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        System.out.println("images.size() = " + images.size());
        for(int i = 0; i<images.size(); i++){
            images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            images.get(i).click();
            System.out.println(i+1+". title: "+driver.getTitle());
            driver.navigate().back();
        }
    }

}
