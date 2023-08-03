package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q01_Actions_DrawShapes extends TestBase {
    /*
 Go to http://szimek.github.io/signature_pad/
 Draw the line or shape you want on the screen
 Press the clear button after drawing
 Close the page
  */
    @Test
    public void actions_DrawShapes() throws InterruptedException {
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement board = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(board);

        for (int i=0; i<10; i++){
            actions.moveByOffset(-5, -5); //Moves element by number of pixels to the left
        }
        for (int i=0; i<10; i++){
            actions.moveByOffset(0, 5); //Moves element by number of pixels to the left
        }
        for (int i=0; i<10; i++){
            actions.moveByOffset(5, 0); //Moves element by number of pixels to the left
        }
        actions.release().perform();

        driver.findElement(By.xpath("//button[.='Clear']"));

        Thread.sleep(3000);
        driver.close();
    }
}
