package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_AccountCreation {
    /*  1. Launch browser - DONE IN setUp
        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"));
        4. Click on 'Signup / Login' button
        5. Verify 'New User Signup!' is visible
        6. Enter name and email address
        7. Click 'Signup' button
    */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void accountCreationTest(){
        driver.get("https://www.automationexercise.com");
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"));
        driver.findElement(By.partialLinkText("Signup / Login")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed());
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Johnny Walker");

        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("nowayjose5@gmail.com");
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible - N/A
//        9. Fill details: Title, Name, Email, Password, Date of birth
//        10. Select checkbox 'Sign up for our newsletter!'
//        11. Select checkbox 'Receive special offers from our partners!'
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        13. Click 'Create Account button'
//        14. Verify that 'ACCOUNT CREATED!' is visible
//        15. Click 'Continue' button
//        16. Verify that 'Logged in as username' is visible
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        driver.findElement(By.id("id_gender1")).click();
        //Name and Email are already filled
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testing1234!");
        //Date of Birth --> dropdown has 3 selectBy() methods: 1.Index, 2. Value, and 3. Visible Text
        //DAY
        //1. Locate the day dropdown element
        WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
        //2. Create select object
        Select daySelect = new Select(day);
        //3. Use select object to interact with dropdown
        daySelect.selectByIndex(5); //Using index to select day 5. - Note: Index starts at 0
        //MONTH
        //1. Locate the day dropdown element
        WebElement month = driver.findElement(By.cssSelector("select[data-qa='months']"));
        //2. Create select object
        Select monthSelect = new Select(month);
        //3. Use select object to interact with dropdown
        monthSelect.selectByValue("5"); //Using value to select May value of "5"
        //YEAR
        //1. Locate the day dropdown element
        WebElement year = driver.findElement(By.cssSelector("select[data-qa='years']"));
        //2. Create select object
        Select yearSelect = new Select(year);
        //3. Use select object to interact with dropdown
        yearSelect.selectByVisibleText("2000"); //Using visible text to select 2000

        driver.findElement(By.cssSelector("#newsletter")).click();
        driver.findElement(By.cssSelector("#optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("Johnny");
        driver.findElement(By.id("last_name")).sendKeys("Walker");
        driver.findElement(By.id("company")).sendKeys("Google");
        driver.findElement(By.id("address1")).sendKeys("123 Main St");

        WebElement country = driver.findElement(By.id("country"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States");

        driver.findElement(By.id("state")).sendKeys("NY");
        driver.findElement(By.id("city")).sendKeys("NYC");
        driver.findElement(By.id("zipcode")).sendKeys("34512");
        driver.findElement(By.id("mobile_number")).sendKeys("+12403980544");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        //        NOTE: THERE IS A WEB POP UP THAT IS SHOWING UP AND WE MUST CLICK CLOSE TO PROCEED
//        USING TRY CATCH BECAUSE THIS POP UP MAY NOT ALWAYS SHOW UP
        try {
            Thread.sleep(10000);
//            try to click the web pop up if it shows up
//            if the pop-up doesn't up, then do not fail.... just catch it.. and continue the test case
            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        }catch (Exception e){
            System.out.println("POP UP IS NOT DISPLAYED... JUST CONTINUE");
        }

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Logged in as')]")).isDisplayed());
        driver.findElement(By.xpath("//*[contains(text(), 'Delete Account')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Delete Account')]")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();






    }
}
