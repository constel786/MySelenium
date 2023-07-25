package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;

public class Day08_FileUploadTest extends TestBase {
//    Class Name: FileUploadTest
//    Method Name: fileUploadTest
//    When user goes to https://testpages.herokuapp.com/styled/file-upload-test.html
//    When user selects an image from the desktop
//    And click on the upload button
//    Then verify the ‘You uploaded a file. This is the result.’ Message displayed

@Test
    public void fileUploadTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/upload");
    String pathOfTheFile = System.getProperty("user.home")+"/Downloads/image.jpeg";
    //Since the input type is "File", we can use sendKeys() method to upload the file
    //ALTERNATIVELY we can use the Java Robot class
    //Locate the input web element
    WebElement chooseFileInput = driver.findElement(By.id("file-upload"));
    chooseFileInput.sendKeys(pathOfTheFile);

    Thread.sleep(2000);
    driver.findElement(By.id("file-submit")).click();
    String fileUploadedMessage = driver.findElement(By.xpath("//h3")).getText();
    assertEquals("File Uploaded!", fileUploadedMessage);




}


}
