package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertTrue;

public class Day08_AutoSuggestion extends TestBase {
    @Test
    public void autoSuggestion(){
//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
//        When user type "uni" in the search box
//        And select the 'United Kingdom' from the suggestions
//        And click on submit button
//        Then verify the result contains 'United Kingdom'

            driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
            driver.findElement(By.id("myCountry")).sendKeys("uni");
            driver.findElement(By.xpath("//div[.='United Kingdom']")).click();
            driver.findElement(By.cssSelector("input[type='button']")).click();
            String resultText = driver.findElement(By.cssSelector("#result")).getText();
            assertTrue(resultText.contains("United Kingdom"));
    }
}
