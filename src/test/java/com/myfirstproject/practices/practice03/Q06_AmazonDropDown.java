package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Q06_AmazonDropDown extends TestBase {
    /*
  Go to https://amazon.com
  Print all the options in the 'Departments' dropdown on the left side of the search box
  Search for each first five options and print titles
   */
@Test
    public void amazonDropDown(){
    driver.get("https://amazon.com");
    List< WebElement> options = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
    options.forEach(t-> System.out.println(t.getText())); //Using Lambda is recommended

    //Classic Java is for (WebElement w : options){
    //                  System.out.println(w.getText());
    //                }

    System.out.println("\nTitles: ");
for (int i=0; i<5; i++){
    options = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions(); //To avoid stale elements
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(options.get(i).getText(), Keys.ENTER);
    System.out.println(driver.getTitle());
    driver.navigate().back();

        }
    }
}
