package _03_Xml_File_Tool;

import org.testng.annotations.Test;
import utility.BaseDriver;

public class Groups extends BaseDriver {

    @Test(groups = "Smoke")
    public void test1() {
        System.out.println("Merhaba dunya 1 .");
        driver.get("https://techno.study/");

    }

    @Test(groups = "Regression")
    public void test2() {
        System.out.println("Merhaba dunya 2 .");
    }

    @Test(groups = "Deneme")
    public void test3() {
        System.out.println("Merhaba dunya 3 .");
    }
}
