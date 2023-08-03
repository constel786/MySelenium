package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Q02_EmojiList extends TestBase {
    @Test
    public void test02(){
         /*
    Given
       Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
       Click on the "Animals and Nature" emoji
    And
       Print emojis under "Animals and Nature" emoji
    And
       Fill the form
    And
       Press the apply button
    Then
       Verify "code" element is displayed
    */
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // This WebElement is inside an iFrame so we have to switch to it first
        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();
        WebElement emojis = driver.findElement(By.xpath("//div[@id='nature']/div"));
        System.out.println("emojis.getText() = " + emojis.getText());

    //go outside of the iFrame to access form
        driver.switchTo().defaultContent();
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        List<String> texts = new ArrayList<>(Arrays.asList("This", "iFrame", "example", "looks", "really", "very", "funny", "does", "not", "it", "?"));
        for (int i = 0; i< inputs.size(); i++){
            inputs.get(i).sendKeys(texts.get(i));
        }
        driver.findElement(By.id("send"));
        assertTrue(driver.findElement(By.id("code")).isDisplayed());

    }
}
