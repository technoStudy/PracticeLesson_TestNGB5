package _00_TestNGIntro;

import org.testng.annotations.Test;

public class _03_Enabled {
    // enable

    @Test
    public void c_language() {
        System.out.println("C language");
    }

    @Test (enabled = false)
    public void jira() {
        System.out.println("Jira");
    }

    @Test
    public void java() {
        System.out.println("Java Language");
    }

}
