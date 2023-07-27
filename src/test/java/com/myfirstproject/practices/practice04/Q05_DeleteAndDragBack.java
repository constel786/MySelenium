package com.myfirstproject.practices.practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Q05_DeleteAndDragBack extends TestBase {
    /*
  Go to URL : https://www.globalsqa.com/demo-site/draganddrop/
  Delete images by clicking delete buttons
  Recycle images by clicking Recycle buttons
  Delete images by drag and drop
  Recycle images by drag and drop
 */
    @Test
    public void deleteAndDragBak() throws InterruptedException {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iFrame);
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[.='Delete image']"));
        deleteButtons.forEach(WebElement::click);

        Thread.sleep(1000);
        List<WebElement> recycleButtons = driver.findElements(By.xpath("//a[.='Recycle image']"));
        System.out.println("recycleButtons.size() = " + recycleButtons.size());
        recycleButtons.forEach(WebElement::click);
//      OR for (WebElement w : recycleButtons) {
//            Thread.sleep(1000);
//            w.click();
//         }

        Thread.sleep(1000);
        List<WebElement> images = driver.findElements(By.xpath("//ul[@id='gallery']/li"));
        WebElement trash = driver.findElement(By.id("trash"));
        Actions actions = new Actions(driver);
        images.forEach(t->actions.pause(500).dragAndDrop(t, trash).perform());

        Thread.sleep(1000);
        WebElement gallery = driver.findElement(By.id("gallery"));
        images.forEach(t->actions.pause(500).dragAndDrop(t, gallery).perform());

        //Find an assertion


    }
}
