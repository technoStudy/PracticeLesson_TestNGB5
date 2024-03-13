package _00_TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Assertions {

    @Test
    public void testCase() {
        String text01 = "Java is a programming language.";
        String text02 = "Java is a programming language.";

        Assert.assertSame(text01, text02);
        Assert.assertEquals(text02, text01);
        Assert.assertEquals(text01, text02);

        System.out.println("Test case passed successfully");

    }

    @Test (priority = 1)
    public void testCaseOne() {
        String text01 = "Hello!";
        String text02 = "Hello!";

        Assert.assertSame(text01, text02, "Contents are not SAME");
        System.out.println("Test case one passed successfully");
    }

    @Test (priority = 2)
    public void testCaseTwo() {
        String text01 = "Java";
        String text02 = "Java";

        Assert.assertEquals(text01, text02, "Contents are not EQUALS");
        System.out.println("Test case two passed successfully");
    }

    @Test (priority = 3)
    public void testCaseThree() {
        String text01 = "Selenium";
        String text02 = "Selenium";

        Assert.assertSame(text01, text02, "Address of both string objects are not same");
        System.out.println("Test case three passed successfully");
    }
}
