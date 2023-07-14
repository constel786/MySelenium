package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

public class Day02_JUnitAssertions {
    /*
    What are assertions?
      Assertions are used to check if expected is equal to actual
      Assertions are very important and are a must to improve the quality of the application
      expected  = actual ==> PASS
      expected != actual ==> FAIL
      ****************************
      assertEquals
      assertTrue
      assertFalse
      ****************************
      These are hard assertions, meaning if JUnit assertion fails then the test case stops executing
      Verification: Soft assertion, meaning if soft assertion fails the test case continues to execute
      Note: There is no soft assert in JUnit
     */

    @Test
    public void assertions(){
        Assert.assertEquals(5,5);
       // Assert.assertEquals("Test case failed", 5, 4); //If test case fails, we see the message

        Assert.assertTrue("apple".contains("a"));
       // Assert.assertTrue("apple".contains("b")); //Fails

        Assert.assertFalse("orange".contains("w")); //Passes
    }
}
