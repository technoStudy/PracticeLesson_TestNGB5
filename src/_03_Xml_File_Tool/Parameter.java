package _03_Xml_File_Tool;

import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter extends Browser {
    @Test
    @Parameters("msg")
    public void testlogin(String sifre) {
        System.out.println("Sifre =" + sifre);
    }

    @Test
    @Ignore
    public void testBekle() {
        System.out.println("Merhaba");
    }
}
