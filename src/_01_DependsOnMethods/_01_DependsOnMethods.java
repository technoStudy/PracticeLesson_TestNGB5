package _01_DependsOnMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _01_DependsOnMethods extends BaseDriver {

    String eMailStr="testing"+((int)(Math.random()*10000))+"@testing.com";

    String passwordStr="abCD123456.";

    @Test
    public void registerTest(){

        driver.get("http://demo.nopcommerce.com/");

        WebElement registerLink= driver.findElement(By.xpath("//a[text()='Register']"));
        registerLink.click();

        WebElement genderMale= driver.findElement(By.id("gender-male"));
        genderMale.click();

        WebElement firstName= driver.findElement(By.id("FirstName"));
        firstName.sendKeys("First");

        WebElement lastName= driver.findElement(By.id("LastName"));
        lastName.sendKeys("Last");

        WebElement eMail= driver.findElement(By.id("Email"));
        eMail.sendKeys(eMailStr);

        WebElement company= driver.findElement(By.id("Company"));
        company.sendKeys("Company");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys(passwordStr);

        WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys(passwordStr);

        WebElement registerButton= driver.findElement(By.cssSelector("div[class='buttons'] button"));
        registerButton.click();

        WebElement confirmText=driver.findElement(By.cssSelector("div[class='result']"));
        String confirmTextStr=confirmText.getText();

        Assert.assertTrue(confirmTextStr.contains("registration completed"));
   }

    @Test (dependsOnMethods= "registerTest")
    public void loginTest(){

        driver.get("http://demo.nopcommerce.com/");

        WebElement loginLink= driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement eMail= driver.findElement(By.id("Email"));
        eMail.sendKeys(eMailStr);

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys(passwordStr);

        WebElement loginButton=driver.findElement(By.xpath("//button[text()='Log in']"));
        loginButton.click();

        WebElement logoutText=driver.findElement(By.linkText("Log out"));

        Assert.assertTrue(logoutText.isDisplayed());
    }
}
