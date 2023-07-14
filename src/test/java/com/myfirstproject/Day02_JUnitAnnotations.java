package com.myfirstproject;

import org.junit.*;

public class Day02_JUnitAnnotations {
    /*
    In JUnit, there are six (6) annotations:
    - @Test annotation: Creates test cases
        - All test cases should be void, no return type
    - @Before and @After methods: Run before or after each @Test annotation
    - @BeforeClass and @AfterClass: Run only once for each class
    - @Ignore: Used to skip or ignore a test case
     */

    @Before
    public void setUp(){
        System.out.println("Set up...");
    }
    @After
    public void tearDown(){
        System.out.println("Tear down...");
    }
    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before class...");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After class...");
    }
    @Test
    public void test01(){
        System.out.println("Test case 1");
    }
    @Test @Ignore //Ignores test02()
    public void test02(){
        System.out.println("Test case 2");
    }
    @Test
    public void test03(){
        System.out.println("Test case 3");
    }
    @Test
    public void test04(){
        System.out.println("Test case 4");
    }
    @Test
    public void test05(){
        System.out.println("Test case 5");
    }
    @Test
    public void test06(){
        System.out.println("Test case 6");
    }

}
