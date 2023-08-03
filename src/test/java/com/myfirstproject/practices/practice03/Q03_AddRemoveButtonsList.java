package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Q03_AddRemoveButtonsList extends TestBase {
    @Test
    public void test03(){
        /*
Given
    Go to http://the-internet.herokuapp.com/add_remove_elements/
When
    Click on the "Add Element" button 100 times
And
    Click on the "Delete" button 20 times
Then
    Assert that 20 buttons were deleted.
  */
    driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    for (int i = 0; i<100; i++) {
        driver.findElement(By.xpath("//button[.='Add Element']")).click();
    }
    List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButtonsBeforeDeleteSize = " + deleteButtons.size());
        for (int i = 0; i<20; i++){
        deleteButtons.get(i).click();
    }
    //Assert that 20 buttons were deleted
    List<WebElement> deleteButtonsAfterDelete = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButtonsAfterDeleteSize = " + deleteButtonsAfterDelete.size());
        assertEquals(deleteButtons.size()-20, deleteButtonsAfterDelete.size());
    }
}
