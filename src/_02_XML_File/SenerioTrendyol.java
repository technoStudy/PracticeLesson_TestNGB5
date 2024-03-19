package _02_XML_File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import src.utility.MyFunction;

import static src.utility.BaseDriver.driver;

public class SenerioTrendyol {
 @BeforeTest
    public void start(){
     driver.get("https://www.trendyol.com/");
 }

 @Test
 public void testScenerio(){
     MyFunction.wait(5);

     WebElement searchBar= driver.findElement(By.xpath("//input[@type='text'][1]"));
     searchBar.sendKeys("ayakkabi");

     driver.findElement(By.xpath("//*[@class=\"cyrzo7gC\"]")).click();

     MyFunction.wait(3);

     WebElement firstobj = driver.findElement(By.xpath("//span[@class='prdct-desc-cntnr-name hasRatings'][1]"));

     System.out.println(" ilk urun adi : "+ firstobj.getText());


 }

 @AfterTest
    public  void end(){
     driver.quit();
 }




}
