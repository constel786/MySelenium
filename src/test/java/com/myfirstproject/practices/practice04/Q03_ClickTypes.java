package com.myfirstproject.practices.practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q03_ClickTypes extends TestBase {

//Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
//Click all the buttons and verify they are all clicked
    @Test
    public void clickTypes() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        WebElement onblur = driver.findElement(By.id("onblur"));
        WebElement onclick = driver.findElement(By.id("onclick"));
        onblur.click();
        Thread.sleep(2000);
        onclick.click(); //This click will not trigger onblur
        Thread.sleep(2000);
        onblur.click(); //We need to click on onclick one more time to trigger it
        Thread.sleep(2000);

    }


}
