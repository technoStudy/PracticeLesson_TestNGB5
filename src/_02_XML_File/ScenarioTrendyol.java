package _02_XML_File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Tools;

import static utility.BaseDriver.driver;


public class ScenarioTrendyol {
    @BeforeTest
    public void start() {
        driver.get("https://www.trendyol.com/");
    }

    @Test
    public void testScenerio() {
        Tools.wait(5);

        WebElement searchBar = driver.findElement(By.xpath("//input[@type='text'][1]"));
        searchBar.sendKeys("ayakkabi");

        driver.findElement(By.xpath("//*[@class=\"cyrzo7gC\"]")).click();
        Tools.wait(3);

        WebElement firstobj = driver.findElement(By.xpath("//span[@class='prdct-desc-cntnr-name hasRatings'][1]"));

        System.out.println(" ilk urun adi : " + firstobj.getText());


    }

    @AfterTest
    public void end() {
        driver.quit();
    }


}
