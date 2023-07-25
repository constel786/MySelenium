package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {
//    Create a class:FileDownloadTest
//    downloadTest()
//    In the downloadTest() method, do the following test:
//    https://the-internet.herokuapp.com/download
//    Download testFile.txt file
//    Then verify if the file downloaded successfully
@Test
    public void downloadTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/download");
    driver.findElement(By.linkText("test.txt"));
    Thread.sleep(3000);
    String filePath = System.getProperty("user.home")+"/Downloads/test.txt";

    boolean isFileDownloaded = Files.exists(Paths.get(filePath));
    Assert.assertTrue(isFileDownloaded);


}
}
