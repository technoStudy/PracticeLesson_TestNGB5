package _00_TestNGIntro;

import org.testng.annotations.*;
import utility.BaseDriver;

public class _01_Annotations extends BaseDriver {
    /**
     * @BeforeSuite
        * @BeforeTest
             * @BeforeGroups
                * @BeforeClass
                  * @BeforeMethod
                        * @Test
                        * @Test
                 * @AfterMethod
                 * @AfterClass
             * @AfterGroups
         * @AfterTest
     * @AfterSuit
     */

    @AfterTest
    public void afterTest() {
        System.out.println("After Test done");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite done");
    }
    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Groups done");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class done");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method done");
    }

    @Test
    public void test01() {
        System.out.println("Test01 done");
    }

    @Test
    public void test02() {
        System.out.println("Test02 done");
    }

    @Test
    public void test03() {
        System.out.println("Test03 done");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method done");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class done");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After Groups done");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suit done");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test done");
    }

}
