package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import java.util.Set;
public class Day07_Cookies extends TestBase {
    @Test
    public void cookiesTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
//        1. Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int allCookiesSize = allCookies.size();
        System.out.println("Total Number of Cookies : "+allCookiesSize);
//        2. Print all the cookies
        System.out.println(allCookies);
        for (Cookie eachCookies : allCookies){
            System.out.println("Each Cookie : "+eachCookies);
            System.out.println("Cookies Value : "+eachCookies.getValue());
            System.out.println("Cookies Name : "+eachCookies.getName());
            System.out.println("Cookies Domain : "+eachCookies.getDomain());
            System.out.println("Cookies Expiry : "+eachCookies.getExpiry());
        }
//        3. Get the cookies by their name
        System.out.println("Cookie By Name => "+driver.manage().getCookieNamed("i18n-prefs"));
//        4. Add new cookie
        Cookie myFavCookie = new Cookie("my-cookie", "chocolate-cookie");
        driver.manage().addCookie(myFavCookie);
        Thread.sleep(3000);
        for (Cookie eachCookie : driver.manage().getCookies()){
            System.out.println("eachCookie = " + eachCookie);
        }
//        5. Delete all of the cookies
        driver.manage().deleteCookieNamed("ubid-main");
        Thread.sleep(3000);
        for (Cookie eachCookie : driver.manage().getCookies()){
            System.out.println("ubid-main is DELETED");
            System.out.println("eachCookie = " + eachCookie);
        }
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        for (Cookie eachCookie : driver.manage().getCookies()){
            System.out.println("Deleted all cookies");
            System.out.println("eachCookie = " + eachCookie);
                    
        }
        
    }
}