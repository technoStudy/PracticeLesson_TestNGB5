package _00_TestNGIntro;

import org.testng.annotations.Test;

public class _02_Priority {

    @Test
    public void webStudentLogin() { // (priority=0)
        System.out.println("Student login through web.");
    }

    @Test
    public void mobileStudentLogin() { // (priority=0)
        System.out.println("Student login through mobile.");
    }

    // priority
    @Test(priority = 2)
    public void mango() {
        System.out.println("I am Mango.");
    }

    @Test(priority = 3)
    public void apple() {
        System.out.println("I am Apple.");
    }

    @Test(priority = 1)
    public void watermelon() {
        System.out.println("I am Watermelon.");
    }

}
