package _03_Xml_File_Tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Browser {
    @BeforeClass
    @Parameters("browser")
    public void browserLogin(String browser) {

        WebDriver driver = null;

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
        }
    }
}
