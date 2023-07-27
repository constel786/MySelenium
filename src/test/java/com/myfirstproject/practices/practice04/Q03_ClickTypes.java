package com.myfirstproject.practices.practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q03_ClickTypes extends TestBase {

//Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
//Click all the buttons and verify they are all clicked
    @Test
    public void clickTypes() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        WebElement onblur = driver.findElement(By.id("onblur"));
        WebElement onclick = driver.findElement(By.id("onclick"));
        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));
        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));
        WebElement onfocus = driver.findElement(By.id("onfocus"));
        WebElement onkeydown = driver.findElement(By.id("onkeydown"));
        WebElement onkeyup = driver.findElement(By.id("onkeyup"));
        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        WebElement onmousedown = driver.findElement(By.id("onmousedown"));

        //To do a right-click we need to use the action object
        Actions actions = new Actions(driver);
        actions                                 //method chain
                .click(onblur)
                .click(onclick) //This click will not trigger onblur
                .click(onclick) //We need to click on onclick one more time to trigger it
                .contextClick(oncontextmenu)
                .doubleClick(ondoubleclick)
                .click(onfocus)
                .click(onkeydown).sendKeys(Keys.ENTER) //To trigger onkeydown button, we need to press any key, such as enter
                .click(onkeyup).sendKeys(Keys.SPACE) //Will trigger when for example spacebar is released
                .click(onkeypress).sendKeys(Keys.SPACE)
                .click(onmouseover)
                .moveToElement(onmouseover)
                .moveToElement(onmouseleave) //Need to move mouse to anohter place to trigger
                .moveToElement(onmouseover) //Moved mouse to another place, onmouseover button
                .click(onmousedown)
                .perform(); //Add last. Does not work without perform()

        Thread.sleep(1000);

    }
}
